package com.tsystems.railway.dao;

import com.tsystems.railway.model.Station;

import java.util.List;

public interface StationDao {

    public void addStation(Station station);

    public Station getStationById(long id);

    public void deleteStation(long id);

    public void updateStation(Station station);

    public List<Station> listStations();
}
