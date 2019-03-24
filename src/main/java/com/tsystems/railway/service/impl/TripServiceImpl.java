package com.tsystems.railway.service.impl;


import com.tsystems.railway.DAO.TripDao;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.model.Trip;
import com.tsystems.railway.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Autowired
    private Trip

    @Override
    public void addTrip(TripDTO trip) {
        tripDao.addtrip(trip);
    }

    @Override
    public void updateTrip(Trip trip) {
        tripDao.updateTrip(trip);
    }

    @Override
    public void deleteTrip(int id) {
        tripDao.deleteTrip(id);
    }

    @Override
    public List<Trip> listTrips() {
        return tripDao.listTrips();
    }

    @Override
    public Trip getTripById(int id) {
       return tripDao.getTripById(id);
    }

    public List<TripDTO> listTripDTO(){
        List<TripDTO> dtoList = new ArrayList<>();
        List<Trip> tripList = tripDao.listTrips();
        for(Trip trip:tripList){

        }
    }
}
