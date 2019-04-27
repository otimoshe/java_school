package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.entity.Trip;

import java.util.List;

public interface TripService {

    void addTrip(TripDTO trip);

    void deleteTrip(int id);

    void updateTrip(TripDTO trip);

    List<TripDTO> listTripDTOs();

    TripDTO getTripById(int id);

    void addTrip(Trip trip);
}
