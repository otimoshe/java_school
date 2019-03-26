package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.User;


public interface UserDao  {
    User findByUsername(String username);
    public void addUser(User user);
}
