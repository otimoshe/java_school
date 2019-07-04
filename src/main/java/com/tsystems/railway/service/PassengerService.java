package com.tsystems.railway.service;

import com.tsystems.railway.DTO.PassengerDTO;
import com.tsystems.railway.entity.Passenger;

import java.util.List;

public interface PassengerService {
    void addPassenger(Passenger passenger);

    List<PassengerDTO> getPassengerListForUser(int userId);

    PassengerDTO getPassengerById(int id);
}
