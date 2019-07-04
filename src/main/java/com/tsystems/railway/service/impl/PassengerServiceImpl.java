package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.PassengerDao;
import com.tsystems.railway.DTO.PassengerDTO;
import com.tsystems.railway.entity.Passenger;
import com.tsystems.railway.mappers.PassengerMapper;
import com.tsystems.railway.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerDao passengerDao;

    @Autowired
    PassengerMapper passengerMapper;

    @Override
    public void addPassenger(Passenger passenger) {
        this.passengerDao.addPassenger(passenger);
    }

    @Override
    public List<PassengerDTO> getPassengerListForUser(int userId) {
        return passengerMapper.listEntityToDtoList(passengerDao.getPassengerListForUser(userId));
    }

    @Override
    public PassengerDTO getPassengerById(int id) {
        return passengerMapper.entityToDto(passengerDao.getPassengerById(id));
    }
}
