package com.tsystems.railway.service;

import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.SeatStatus;


import java.util.List;

public interface SeatService {
    void addSeat(SeatDTO seatDTO);

    void deleteSeat(int id);

    void updateSeat(SeatDTO seatDTO);

    SeatDTO getSeatById(int id);

    List<SeatDTO> getAllSeatsForTrip(int tripId);

    List<SeatDTO> getAvailableSeatForTrip(int tripId, StationDTO arrivalStation, StationDTO departureStation);

    List<SeatStatus>getStatusesForSeat(int seatId);
}
