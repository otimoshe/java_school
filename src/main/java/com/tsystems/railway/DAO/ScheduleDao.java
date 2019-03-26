package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Schedule;

import java.util.List;

public interface ScheduleDao {

    void addSchedule(Schedule schedule);

    void deleteSchedule(long id);

    Schedule getScheduleById(long id);

    void updateSchedule(Schedule schedule);

    List<Schedule> getAllSchedule();

    List<Schedule> getSchedulesForTrip(int trip);
}
