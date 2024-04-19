package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import org.example.dto.OrderCreateRequestDTO;
import org.example.dto.ProductDTO;
import org.example.entity.Book;
import org.example.entity.Order;
import org.example.utilities.NgrokManager;
import org.example.utilities.PayUAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PayuServiceImplementation implements PayuService {

    private static final String GRANT_TYPE = "client_credentials";
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    @Autowired
    private NgrokManager ngrokManager;
    //private final NgrokClient ngrokClient = new NgrokClient.Builder().build();
    //final Tunnel httpTunnel = ngrokClient.connect(new CreateTunnel())

    @Override
    public OrderCreateRequestDTO createRequestDTO(Order order, String host)
    {

        OrderCreateRequestDTO orderCreateRequestDTO = new OrderCreateRequestDTO();
        orderCreateRequestDTO.setNotifyUrl(ngrokManager.getUrl()+"/helloworld3/payment/notify/"+order.getId());
        orderCreateRequestDTO.setCustomerIp(host);
        orderCreateRequestDTO.setMerchantPosId(CLIENT_ID);
        orderCreateRequestDTO.setDescription("zamowienie");
        orderCreateRequestDTO.setCurrencyCode("PLN");
        orderCreateRequestDTO.setContinueUrl("http://localhost:8080/helloworld3/payment/callback");
        List<ProductDTO> products = convertBooksToProducts(order.getBooks());
        orderCreateRequestDTO.setProducts(products);
        orderCreateRequestDTO.setTotalAmount(String.valueOf(getPriceOfAllProducts(products)));
        return orderCreateRequestDTO;

    }
    @Override
    public PayUAuthToken getAuthToken() throws JsonProcessingException {

        if (ngrokManager.getUrl() == null) ngrokManager.setUpATunnel();

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://secure.snd.payu.com/pl/standard/user/oauth/authorize";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("grant_type", GRANT_TYPE);
        parameters.add("client_id", CLIENT_ID);
        parameters.add("client_secret",CLIENT_SECRET);



        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);

        ResponseEntity<String> jsonResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return new ObjectMapper().readValue(jsonResponse.getBody(), PayUAuthToken.class);
    }


    public List<ProductDTO> convertBooksToProducts(Set<Book> books){
        List<ProductDTO> products = new ArrayList<>();
        for (var book: books)
        {
            var p = new ProductDTO();
            p.setName(book.getName());
            p.setQuantity(1);
            p.setUnitPrice((int) (book.getPrice()*100));
            products.add(p);
        }
        return products;
    }


    public Integer getPriceOfAllProducts(List<ProductDTO> products) {
        int sum = 0;
        for (var product: products)
        {
            sum += product.getUnitPrice()*product.getQuantity();
        }
        return sum;
    }




}
