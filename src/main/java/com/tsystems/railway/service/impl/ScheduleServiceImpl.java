package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.ScheduleDao;
import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.mappers.ScheduleMapper;
import com.tsystems.railway.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public void addSchedule(ScheduleDTO scheduleDTO) {
        scheduleDao.addSchedule(scheduleMapper.dtoToEntity(scheduleDTO));
    }

    @Override
    public void deleteSchedule(long id) {
        scheduleDao.deleteSchedule(id);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleDao.updateSchedule(scheduleMapper.dtoToEntity(scheduleDTO));
    }

    @Override
    public List<ScheduleDTO> scheduleListForTrip(int tripId) {
        return scheduleMapper.listEntityToDtoList(scheduleDao.getSchedulesForTrip(tripId));
    }

    @Override
    public ScheduleDTO getScheduleById(long id) {
        return scheduleMapper.entityToDto(scheduleDao.getScheduleById(id));
    }

    @Override
    public List<ScheduleDTO> getScheduleListForStation(int stationId, Date date) {
        return scheduleMapper.listEntityToDtoList( scheduleDao.getSchedulesForStation(stationId,date));
    }
    @Override
    public List<ScheduleDTO> getScheduleFotTripsAtStation(List<Integer> tripsId, Date date,int stationId){
        return scheduleMapper.listEntityToDtoList(scheduleDao.getScheduleFotTripsAtStation(tripsId, date,stationId));
    }

    public ScheduleDTO getScheduleByTripStation(TripDTO trip,StationDTO station){
        return scheduleMapper.entityToDto(scheduleDao.getScheduleByTripStation(trip.getId(),station.getId()));
    }
    public List<ScheduleDTO> getScheduleByTripsIdStationId(List<Integer> tripsId,int stationId){
        return scheduleMapper.listEntityToDtoList(scheduleDao.getScheduleByTripsIdStationId(tripsId,stationId));
    }

    @Override
    public List<ScheduleDTO> getScheduleFoStationIdDepartDate(int id, Date date) {
        return  scheduleMapper.listEntityToDtoList(scheduleDao.getScheduleFoStationIdDepartDate(id,date));
    }
}
