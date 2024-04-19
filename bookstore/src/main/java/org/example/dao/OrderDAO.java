package org.example.dao;

import org.example.entity.Book;
import org.example.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderDAO {
    List<Order> getOrders();
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    void completeOrder(int orderId);
    Order getOrder(int id);


    List<Order> getOrdersByListOfIds(List<Integer> listOfOrdersIds);
}
