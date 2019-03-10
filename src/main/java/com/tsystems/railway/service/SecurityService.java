package com.tsystems.railway.service;



public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
