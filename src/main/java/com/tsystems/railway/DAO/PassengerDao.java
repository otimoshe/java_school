package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Passenger;

import java.util.List;

public interface PassengerDao {

    void addPassenger(Passenger passenger);

    void deletePassenger(int id);

    void updatePassenger(Passenger passenger);

    Passenger getPassengerById(int id);

    List<Passenger> getAllPassenger();

    List<Passenger> getPassengerListForUser(int userId);
}
