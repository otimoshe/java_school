package com.tsystems.railway.DAO;

import com.tsystems.railway.model.Trip;

import java.util.List;

public interface TripDao {
    public void addtrip(Trip trip);

    public void deleteTrip(int id);

    public void updateTrip(Trip trip);

    public Trip getTripById(int id);

    public List<Trip> listTrips();
}
