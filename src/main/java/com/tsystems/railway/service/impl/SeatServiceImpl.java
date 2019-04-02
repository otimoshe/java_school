package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.SeatDao;
import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Seat;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.mappers.SeatMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDao seatDao;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public void addSeat(SeatDTO seatDTO) {
        seatDao.addSeat(seatMapper.dtoToEntity(seatDTO));
    }

    @Override
    public void deleteSeat(int id) {
        seatDao.deleteSeat(id);
    }

    @Override
    public void updateSeat(SeatDTO seatDTO) {
        seatDao.updateSeat(seatMapper.dtoToEntity(seatDTO));
    }

    @Override
    public SeatDTO getSeatById(int id) {
        return seatMapper.entityToDto(seatDao.getSeatById(id));
    }

    @Override
    public List<SeatDTO> getAllSeatsForTrip(int tripId) {
        return seatMapper.listEntityToDtoList(seatDao.listSeatsForTrip(tripId));
    }

    public List<SeatDTO> getAvailableSeatForTrip(int tripId, StationDTO arrivalStation, StationDTO departureStation){
        List<Seat> seats = seatDao.listSeatsForTrip(tripId);
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat:seats){
            if( seat.isAvailable(stationMapper.dtoToEntity(arrivalStation),stationMapper.dtoToEntity(departureStation))){
                availableSeats.add(seat);
            }
        }
        return seatMapper.listEntityToDtoList(availableSeats);
    }
}
