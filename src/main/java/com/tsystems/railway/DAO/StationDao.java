package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationDao {

    void addStation(Station station);

    Station getStationById(int id);

    void deleteStation(int id);

    void updateStation(Station station);

    List<Station> listStations();

    Station getStationByName(String name);
}
