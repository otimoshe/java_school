package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.SeatStatus;

import java.util.List;

public interface SeatStatusDao {

    void addSeatStatus(SeatStatus seatStatus);

    void deleteSeatStatus(int id);

    void updateSeatStatus(SeatStatus seatStatus);

    List<SeatStatus> getSeatStatusesForSeat(int seatId);

    SeatStatus getSeatStatusById(int id);
}
