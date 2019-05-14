package com.tsystems.railway.service;

import com.tsystems.railway.DTO.PassengerDTO;

import java.util.List;

public interface PassengerService {
    void addPassenger(PassengerDTO passenger);

    List<PassengerDTO> getPassengerListForUser(int userId);

    PassengerDTO getPassengerById(int id);
}
