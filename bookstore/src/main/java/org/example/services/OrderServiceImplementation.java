package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{


    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Order> getOrders() {

        return orderDAO.getOrders();
    }

    @Override
    @Transactional
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    @Transactional
    public List<Order> getOrders(String username) {
        return orderDAO.getOrders(username);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public void completeOrder(int orderId) {
        orderDAO.completeOrder(orderId);
    }

    @Override
    @Transactional
    public List<Order> getOrdersByListOfIds(List<Integer> listOfOrdersIds) {
        return orderDAO.getOrdersByListOfIds(listOfOrdersIds);
    }
}
