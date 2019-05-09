package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.StationDao;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public void addStation(StationDTO station){
        this.stationDao.addStation(stationMapper.dtoToEntity(station));
    }

    @Override
    public void deleteStation(int id) {
        this.stationDao.deleteStation(id);
    }

    @Override
    public void updateStation(StationDTO station) {
        this.stationDao.updateStation(stationMapper.dtoToEntity(station));
    }

    @Override
    public StationDTO getStationById(int id) {
       return this.stationMapper.entityToDto(stationDao.getStationById(id));
    }

    @Override
    public List<StationDTO> listStations() {
        return this.stationMapper.listEntityToDtoList(stationDao.listStations());
    }

    @Override
    public StationDTO getStationByName(String name) {
         return this.stationMapper.entityToDto(stationDao.getStationByName(name));
    }
}
