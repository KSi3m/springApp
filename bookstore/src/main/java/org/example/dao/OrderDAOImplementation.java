package org.example.dao;

import org.example.entity.Book;
import org.example.entity.Category;
import org.example.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class OrderDAOImplementation implements OrderDAO{


    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Order> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> query = currentSession.createQuery("SELECT DISTINCT o from Order as o LEFT JOIN FETCH o.books", Order.class);
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Order> getOrders(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> query = currentSession.createQuery("SELECT DISTINCT o from Order as o LEFT JOIN FETCH o.books WHERE o.user.username = (:username)", Order.class).setParameter("username",username);
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void completeOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("From Order o WHERE o.id = (:orderId)", Order.class).setParameter("orderId",orderId);
        List<Order> orders = query.getResultList();
        orders.get(0).setStatus("FINISHED");
    }

    @Override
    public Order getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("SELECT DISTINCT o from Order as o LEFT JOIN FETCH o.books where o.id='"+id+"'", Order.class);
        List<Order> orders = query.getResultList();
        return orders.get(0);

    }

    @Override
    public List<Order> getOrdersByListOfIds(List<Integer> listOfOrdersIds) {
        Session session = sessionFactory.getCurrentSession();
        if (listOfOrdersIds.isEmpty()) return new ArrayList<>();
        Query<Order> query = session.createQuery("SELECT DISTINCT o from Order as o LEFT JOIN FETCH o.books where o.id IN (:listOfOrdersIds)", Order.class).setParameterList("listOfOrdersIds",listOfOrdersIds);
        List<Order> orders = query.getResultList();
        return orders;
    }


}
