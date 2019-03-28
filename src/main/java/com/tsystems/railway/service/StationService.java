package com.tsystems.railway.service;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationService {

    void addStation(StationDTO station);

    void deleteStation(int id);

    void updateStation(StationDTO station);

    StationDTO getStationById(int id);

    List<StationDTO> listStations();
}
