package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationDao {

    public void addStation(Station station);

    public Station getStationById(int id);

    public void deleteStation(int id);

    public void updateStation(Station station);

    public List<Station> listStations();
}
