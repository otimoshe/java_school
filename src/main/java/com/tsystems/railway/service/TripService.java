package com.tsystems.railway.service;

import com.tsystems.railway.DTO.*;

import java.sql.Date;
import java.util.List;

public interface TripService {

    void deleteTrip(int id);

    void updateTrip(TripDTO trip);

    List<TripDTO> listTripDTOs();

    TripDTO getTripById(int id);

    List<TripDTO> getTripListWithIds(List<Integer> tripsId);

    List<RouteDTO> getAllRoutes();

    List<TrainDTO> getAllTrains();

    void createTrip(int routeID, int templateId, Date date, int trainId);

    List<ScheduleDTO> getSchedulesForTrip(int tripId);

    List<TimeTemplateDTO> getTemplatesForRoute(int routeID);

    RouteDTO getRouteById(int routeId);

    TrainDTO getTrainById(int trainId);

    TimeTemplateDTO getTimeTemplateById(int timeTemplateID);

    List<TripDTO> findRelevantTrips(String departureStationName, String arrivalStationName, Date date);

    List<StationDTO> getAllStation();

    List<TicketForm> getScheduleBoardInfo(List<TripDTO> trips, String departStationName, String arriveStationName);

    StationDTO getStationbyId(int id);

    List<TripDTO> listTripsInDay(Date date);
}
