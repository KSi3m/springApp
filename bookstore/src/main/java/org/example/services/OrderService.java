package org.example.services;

import org.example.entity.Book;
import org.example.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {
    List<Order> getOrders();
    Order getOrder(int id);
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    void completeOrder(int orderId);
    public List<Order> getOrdersByListOfIds(List<Integer> listOfOrdersIds);
}
