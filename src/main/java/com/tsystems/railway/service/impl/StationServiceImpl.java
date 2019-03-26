package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.StationDao;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Override
    public void addStation(Station station){
        this.stationDao.addStation(station);
    }

    @Override
    public void deleteStation(long id) {
        this.stationDao.deleteStation(id);
    }

    @Override
    public void updateStation(Station station) {
        this.stationDao.updateStation(station);
    }

    @Override
    public void getStationById(long id) {
        this.stationDao.getStationById(id);
    }

    @Override
    public List<Station> listStations() {
        return this.stationDao.listStations();
    }


}
