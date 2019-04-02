package com.tsystems.railway.service.impl;


import com.tsystems.railway.DAO.TripDao;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.TrainMapper;
import com.tsystems.railway.mappers.TripMapper;
import com.tsystems.railway.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Autowired
    private TripMapper tripMapper;



    @Override
    public void addTrip(TripDTO trip) {
        tripDao.addtrip(tripMapper.dtoToEntity(trip));
    }

    @Override
    public void updateTrip(TripDTO trip) {
        tripDao.updateTrip(tripMapper.dtoToEntity(trip));
    }

    @Override
    public void deleteTrip(int id) {
        tripDao.deleteTrip(id);
    }

    @Override
    public List<TripDTO> listTripDTOs() {
        return tripMapper.listEntityToDtoList(tripDao.listTrips());
    }

    @Override
    public TripDTO getTripById(int id) {
       return tripMapper.entityToDto(tripDao.getTripById(id));
    }



}
