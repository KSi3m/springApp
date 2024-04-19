package org.example.dao;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImplementation implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, username);
        return user;
    }
}
