package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.RoleDao;
import com.tsystems.railway.DAO.UserDao;
import com.tsystems.railway.DTO.UserDTO;
import com.tsystems.railway.entity.User;
import com.tsystems.railway.mappers.UserMapper;
import com.tsystems.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleDao.getRoleById( (long) 2)); // set role "user"
        userDao.addUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return  userDao.findByUsername(username);
    }

}
