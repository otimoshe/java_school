package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PassengerDTO;
import com.tsystems.railway.DTO.UserDTO;
import com.tsystems.railway.entity.Passenger;
import com.tsystems.railway.entity.User;

public interface UserMapper {

    User dtoToEntity(UserDTO userDTO);

    UserDTO entityToDto(User user);

}
