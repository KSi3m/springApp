package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.OrderCreateRequestDTO;
import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.entity.Book;
import org.example.entity.Order;
import org.example.utilities.PayUAuthToken;

import java.util.List;
import java.util.Set;

public interface PayuService {

    OrderCreateRequestDTO createRequestDTO(Order order, String host);

    public PayUAuthToken getAuthToken() throws JsonProcessingException;


}
