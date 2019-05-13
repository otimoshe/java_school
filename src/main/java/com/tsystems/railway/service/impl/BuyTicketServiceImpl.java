package com.tsystems.railway.service.impl;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.Route;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

@Service
@Transactional
public class BuyTicketServiceImpl implements BuyTicketService {

    @Autowired
    private PathService pathService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TripService tripService;

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public List<TripDTO> findRelevantTrips(String departureStationName, String arrivalStationName, Date date) {
        Station departStation = stationMapper.dtoToEntity(stationService.getStationByName(departureStationName));
        Station arrivalStation = stationMapper.dtoToEntity(stationService.getStationByName(arrivalStationName));
        List<TripDTO> allTrips = tripService.listTripDTOs();
        List<Integer> tripsId = new ArrayList<>();
        for(TripDTO trip:allTrips){
            Route route = routeMapper.dtoToEntity(trip.getRoute());
           if ( (route.getStationList().contains(departStation)) && (route.getStationList()).contains(arrivalStation) &&
                   (route.getStationList().indexOf(departStation) < route.getStationList().indexOf(arrivalStation) )){
                tripsId.add(trip.getId());
           }
        }
        List<ScheduleDTO> schedules = scheduleService.getScheduleFotTripsAtStation(tripsId,date,departStation.getId());
        List<Integer> resultTripsId = new ArrayList<>();
        for(ScheduleDTO schedule :schedules){
            resultTripsId.add(schedule.getTrip().getId());
        }
        List<TripDTO> resultTrips = tripService.getTripListWithIds(resultTripsId);

        return resultTrips;
    }

    @Override
    public Set<StationDTO> getAvailableStationForStation(int stationId) {
        List<PathDTO> paths = pathService.pathsForStation(stationId);
        Set<StationDTO> stations = new HashSet<>();
        for(PathDTO path:paths){
            stations.add(path.getStation());
            stations.add(path.getNextStation());
        }
        stations.remove(stationService.getStationById(stationId));
        return stations;
    }
    public List<List<StationDTO>> findWays(int departStationId,int arriveStationId){
        List<List<StationDTO>> result = new ArrayList<>();
        StationDTO departStation = stationService.getStationById(departStationId);
        StationDTO arriveStation = stationService.getStationById(arriveStationId);

        StationDTO currentStation = departStation;
        List<StationDTO> currentWay = new ArrayList<>();
        currentWay.add(currentStation);
        List<StationDTO> visitedStations = new ArrayList<>();

        List<PathDTO> pathDTOS = pathService.pathsForStation(currentStation.getId());
        Map<StationDTO,Double> availableStations = new HashMap<>();

        for (PathDTO path : pathDTOS){
            if (path.getStation().equals(departStation)){
                availableStations.put(path.getNextStation(),path.getDistance());
            }else{
                availableStations.put(path.getStation(),path.getDistance());
            }
        }

        if (availableStations.containsKey(departStation)){
            currentWay.add(departStation);
            result.add(currentWay);
        }else {

        }


        return null;
    }

    @Override
    public TicketDTO buyTicket() {
        return null;
    }
}
