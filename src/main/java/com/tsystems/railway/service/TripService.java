package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.model.Trip;

import java.util.List;

public interface TripService {

    public void addTrip(TripDTO trip);

    public void deleteTrip(int id);

    public void updateTrip(TripDTO trip);

    public List<TripDTO> listTripDTOs();

    public TripDTO getTripById(int id);
}
