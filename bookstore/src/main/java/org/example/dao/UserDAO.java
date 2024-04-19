package org.example.dao;

import org.example.entity.User;

public interface UserDAO {
    public void saveUser(User user);
    public User getUser(String username);
}
