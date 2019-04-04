package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.entity.Trip;
import com.tsystems.railway.mappers.ScheduleMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.mappers.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Autowired
    StationMapper stationMapper;

    @Autowired
    TripMapper tripMapper;

    @Override
    public Schedule dtoToEntity(ScheduleDTO scheduleDTO) {
        long id = scheduleDTO.getId();
        Trip trip = tripMapper.dtoToEntity(scheduleDTO.getTrip());
        Station station = stationMapper.dtoToEntity(scheduleDTO.getStation());
        Date arrivalDate = scheduleDTO.getArrivalDate();
        Date departureDate = scheduleDTO.getDepartureDate();
        Time departureTime = scheduleDTO.getDepartureTime();
        Time arrivalTime = scheduleDTO.getArrivalTime();

        return new Schedule(id, trip, arrivalDate, departureDate, station,departureTime,arrivalTime);
    }

    @Override
    public ScheduleDTO entityToDto(Schedule schedule) {
        long id = schedule.getId();
        TripDTO trip = tripMapper.entityToDto(schedule.getTrip());
        StationDTO station = stationMapper.entityToDto(schedule.getStation());
        Date arrivalDate = schedule.getArrivalDate();
        Date departureDate = schedule.getDepartureDate();
        Time departureTime = schedule.getDepartureTime();
        Time arrivalTime = schedule.getArrivalTime();

        return new ScheduleDTO(id, trip, arrivalDate, departureDate, station,departureTime,arrivalTime);
    }

    @Override
    public List<ScheduleDTO> listEntityToDtoList(List<Schedule> schedules) {
       List<ScheduleDTO> dtoList = new ArrayList<>();
       for(Schedule schedule:schedules){
           dtoList.add(this.entityToDto(schedule));
       }
        return dtoList;
    }

    @Override
    public List<Schedule> listDtoToEntityList(List<ScheduleDTO> dtoList) {
        List<Schedule> schedules = new ArrayList<>();
        for(ScheduleDTO dto:dtoList){
            schedules.add(this.dtoToEntity(dto));
        }
        return schedules;
    }
}
