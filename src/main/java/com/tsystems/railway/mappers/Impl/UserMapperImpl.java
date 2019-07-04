package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.UserDTO;
import com.tsystems.railway.entity.User;
import com.tsystems.railway.mappers.UserMapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        int id = userDTO.getId();
        String name = userDTO.getUsername();
        String password = userDTO.getPassword();


        return new User(id,name,password);
    }

    @Override
    public UserDTO entityToDto(User user) {
        int id = user.getId();
        String name = user.getUsername();
        String password = user.getPassword();
        return new UserDTO(id,name,password);
    }



}
