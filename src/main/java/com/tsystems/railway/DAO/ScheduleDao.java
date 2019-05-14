package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Station;

import java.sql.Date;
import java.util.List;

public interface ScheduleDao {

    void addSchedule(Schedule schedule);

    void deleteSchedule(long id);

    Schedule getScheduleById(long id);

    void updateSchedule(Schedule schedule);

    List<Schedule> getAllSchedule();

    List<Schedule> getSchedulesForTrip(int trip);

    List<Schedule> getSchedulesForStation(int stationId, Date date);

    List<Schedule> getScheduleFotTripsAtStation(List<Integer> tripsId,Date date,int stationId);

    Schedule getScheduleByTripStation(int tripId,int stationId);

    List<Schedule> getScheduleByTripsIdStationId(List<Integer> tripsId,int stationId);

    List<Schedule> getScheduleFoStationIdDepartDate(int id, Date date);
}
