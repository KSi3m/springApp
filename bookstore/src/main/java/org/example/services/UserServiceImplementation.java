package org.example.services;

import org.example.dao.UserDAO;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImplementation implements UserService{

    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImplementation(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(String username) {
        return userDAO.getUser(username);
    }
}
