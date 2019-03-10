package com.tsystems.railway.service;

import com.tsystems.railway.model.User;


public interface UserService {

    void addUser(User user);

    User findByUsername(String username);
}
