package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.example.dto.*;
import org.example.entity.Order;
import org.example.services.BookService;
import org.example.services.OrderService;

import org.example.services.PayuService;
import org.example.utilities.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PayuService payuService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    TokenManager tokenManager;
    @Autowired
    OrderService orderService;

    private void authorize() throws JsonProcessingException {
        this.tokenManager.setToken(payuService.getAuthToken());
    }

    @PostMapping(value= "/order")
    public String createOrderRequest(@ModelAttribute("orderDTO") OrderDTO orderDTO, HttpServletRequest request) throws JsonProcessingException {

        if (!tokenManager.isTokenValid())
            authorize();

        Order order = orderService.getOrder(orderDTO.getId());
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://secure.snd.payu.com/api/v2_1/orders";

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.add(headerName,headerValue);
        }

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(tokenManager.getAccessToken());

        OrderCreateRequestDTO orderCreateRequestDTO = payuService.createRequestDTO(order,request.getRemoteHost());

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());

        restTemplate.setMessageConverters(messageConverters);

        HttpEntity<OrderCreateRequestDTO> requestEntity = new HttpEntity<>(orderCreateRequestDTO, headers);

        ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, JsonNode.class);
        JsonNode jsonNode = responseEntity.getBody();
        String jsonResponse = jsonNode.toString();

        var orderCreateResponse = new ObjectMapper().readValue(jsonResponse, OrderCreateResponseDTO.class);
        return "redirect:"+orderCreateResponse.getRedirectUri();

    }

    @GetMapping("/callback")
    public String handlePaymentCallback(Model model,HttpServletRequest request) throws IOException {
        //System.out.println(request.getInputStream());
        return "redirect:/order/list";
    }

    @PostMapping(value = "/notify/{orderID}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> handle(@PathVariable int orderID,Model model,HttpServletRequest request,@RequestBody String requestBody) throws IOException {
        //System.out.println(requestBody);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        OrderRetrieveResponseDTO orderRetrieveResponseDTO = mapper.readValue(requestBody, OrderRetrieveResponseDTO.class);
        System.out.println(orderRetrieveResponseDTO);
        var order = orderService.getOrder(orderID);
        if (!order.getStatus().equals("COMPLETED") && !order.getStatus().equals("FINISHED") && !order.getStatus().equals("CANCELED"))
        {
            HttpHeaders headers = new HttpHeaders();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                headers.add(headerName, headerValue);
            }
            order.setStatus(orderRetrieveResponseDTO.getOrder().status);
            orderService.saveOrder(order);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



}