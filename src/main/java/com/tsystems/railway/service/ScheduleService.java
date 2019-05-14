package com.tsystems.railway.service;

import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TripDTO;
import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    void addSchedule(ScheduleDTO scheduleDTO);

    void deleteSchedule(long id);

    void updateSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleDTO> scheduleListForTrip(int tripId);

    ScheduleDTO getScheduleById(long id);

    List<ScheduleDTO> getScheduleListForStation(int stationId, Date date);

    List<ScheduleDTO> getScheduleFotTripsAtStation(List<Integer> tripsId, Date date,int stationId);

    ScheduleDTO getScheduleByTripStation(TripDTO trip, StationDTO station);

    List<ScheduleDTO> getScheduleByTripsIdStationId(List<Integer> tripsId,int stationId);

    List<ScheduleDTO> getScheduleFoStationIdDepartDate(int id, Date date);
}
