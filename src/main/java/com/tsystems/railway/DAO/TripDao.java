package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Trip;

import java.util.List;

public interface TripDao {
    void addtrip(Trip trip);

    void deleteTrip(int id);

    void updateTrip(Trip trip);

    Trip getTripById(int id);

    List<Trip> listTrips();

    List<Trip> getTripListWithIds(List<Integer> tripsId);
}
