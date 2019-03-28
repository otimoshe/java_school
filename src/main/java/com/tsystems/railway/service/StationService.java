package com.tsystems.railway.service;

import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationService {

    void addStation(Station station);

    void deleteStation(int id);

    void updateStation(Station station);

    Station getStationById(int id);

    List<Station> listStations();
}
