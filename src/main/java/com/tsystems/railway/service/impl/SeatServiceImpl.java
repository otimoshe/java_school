package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.SeatDao;
import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.mappers.SeatMapper;
import com.tsystems.railway.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDao seatDao;

    @Autowired
    private SeatMapper seatMapper;

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
}
