package com.tsystems.railway.service;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.Trip;

import java.sql.Date;
import java.util.List;

public interface TripService {

    void addTrip(TripDTO trip);

    void deleteTrip(int id);

    void updateTrip(TripDTO trip);

    List<TripDTO> listTripDTOs();

    TripDTO getTripById(int id);

    void addTrip(Trip trip);

    List<TripDTO> getTripListWithIds(List<Integer> tripsId);

    List<RouteDTO> getAllRoutes();

    List<TrainDTO> getAllTrains();

    void createTrip(int routeID, int templateId, Date date, int trainId);

    List<ScheduleDTO> getSchedulesForTrip(int tripId);

    List<TimeTemplateDTO> getTemplatesForRoute(int routeID);

    RouteDTO getRouteById(int routeId);

    TrainDTO getTrainById(int trainId);

    TimeTemplateDTO getTimeTemplateById(int timeTemplateID);

    void addSchedule(ScheduleDTO schedule);

    void addSeat(SeatDTO seat);


}
