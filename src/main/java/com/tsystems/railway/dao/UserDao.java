package com.tsystems.railway.dao;

import com.tsystems.railway.model.User;


public interface UserDao  {
    User findByUsername(String username);
    public void addUser(User user);
}
