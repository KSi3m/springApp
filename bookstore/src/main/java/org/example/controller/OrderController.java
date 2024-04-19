package org.example.controller;

import org.example.cart.Cart;
import org.example.dto.BookDTO;
import org.example.dto.OrderDTO;
import org.example.entity.Book;
import org.example.entity.Order;
import org.example.entity.User;
import org.example.services.BookService;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private Cart cart;

    @GetMapping("/list")
    public String listOfOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("orderDTO",new OrderDTO());
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            List<Order> orders = orderService.getOrders();
            model.addAttribute("orders", orders);
            return "ordersAdmin";
        }else {
            System.out.println(authentication.getName());
            List<Order> orders = orderService.getOrders(authentication.getName());
            model.addAttribute("orders", orders);
            return "orders";
        }
    }

    @GetMapping("/list/all")
    public String listofAllOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("orderDTO",new OrderDTO());
        List<Order> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        return "orders";

    }


    @PostMapping("/saveOrder")
    public String saveOrder(Authentication authentication) {
        if (cart.getBookIds().isEmpty())
        {
            return "redirect:/cart";
        }
        Order order = new Order();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setDateTime(timestamp);
        order.setStatus("NEW");
        order.setUser(new User(authentication.getName()));
        order.setBooks(new HashSet<>(bookService.getBooksByListOfIds(cart.getBookIds())));
        double sum = 0.0;
        for(var x: order.getBooks())
        {
            sum += x.getPrice();
        }

        order.setPrice(sum);
        orderService.saveOrder(order);
        cart.getBookIds().clear();
        return "redirect:/order/list";
    }

    @GetMapping("/complete")
    public String completeOrder(@RequestParam(name = "orderId") int id) {
        orderService.completeOrder(id);
        return "redirect:/order/list";
    }
}
