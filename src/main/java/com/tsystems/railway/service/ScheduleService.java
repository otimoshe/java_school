package com.tsystems.railway.service;

import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    void addSchedule(ScheduleDTO scheduleDTO);
    void deleteSchedule(long id);
    void updateSchedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> scheduleListForTrip(int tripId);
    ScheduleDTO getScheduleById(long id);

}
