package org.example.services;

import org.example.entity.User;

public interface UserService {
    public void saveUser(User user);
    public User getUser(String username);
}
