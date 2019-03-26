package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Station;

import java.util.List;

public interface ScheduleMapper {

    Schedule dtoToEntity(ScheduleDTO scheduleDTO);

    ScheduleDTO entityToDto(Schedule schedule);

    List<ScheduleDTO> listEntityToDtoList(List<Schedule > schedules);

    List<Schedule> listDtoToEntityList(List<ScheduleDTO> dtoList);
}

