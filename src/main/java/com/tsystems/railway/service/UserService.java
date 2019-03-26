package com.tsystems.railway.service;

import com.tsystems.railway.entity.User;


public interface UserService {

    void addUser(User user);

    User findByUsername(String username);
}
