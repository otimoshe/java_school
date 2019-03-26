package com.tsystems.railway.service;

import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationService {

    void addStation(Station station);

    void deleteStation(long id);

    void updateStation(Station station);

    void getStationById(long id);

    List<Station> listStations();
}
