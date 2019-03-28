package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Seat;
import com.tsystems.railway.entity.Trip;

import java.util.List;

public interface SeatDao {
    void addSeat(Seat seat);

    void updateSeat(Seat seat);

    void deleteSeat(int id);

    List<Seat> listSeatsForTrip(int tripId);

    Seat getSeatById(int id);



}
