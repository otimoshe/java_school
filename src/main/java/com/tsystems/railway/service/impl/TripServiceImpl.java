package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TripDao;
import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.*;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.mappers.TripMapper;
import com.tsystems.railway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TimeTemplateService timeTemplateService;

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private StationService stationService;


    @Override
    public void updateTrip(TripDTO trip) {
        tripDao.updateTrip(tripMapper.dtoToEntity(trip));
    }

    @Override
    public void deleteTrip(int id) {
        tripDao.deleteTrip(id);
    }

    @Override
    public List<TripDTO> listTripDTOs() {
        return tripMapper.listEntityToDtoList(tripDao.listTrips());
    }

    @Override
    public TripDTO getTripById(int id) {
        return tripMapper.entityToDto(tripDao.getTripById(id));
    }


    @Override
    public List<TripDTO> getTripListWithIds(List<Integer> tripsId) {
        return tripMapper.listEntityToDtoList(tripDao.getTripListWithIds(tripsId));
    }

    @Override
    public List<RouteDTO> getAllRoutes() {
        return routeService.getDtoRouteList();
    }

    @Override
    public List<TrainDTO> getAllTrains() {
        return trainService.listTrainDTOs();
    }

    @Override
    public void createTrip(int routeID, int templateId, Date date, int trainId) {
        TripDTO tripDTO = new TripDTO();
        RouteDTO route = this.getRouteById(routeID);
        tripDTO.setRoute(route);
        tripDTO.setTrain(this.getTrainById(trainId));
        TimeTemplateDTO timeTemplateDTO = this.getTimeTemplateById(templateId);
        List<StationDTO> stationList = route.getStationList();
        tripDTO.setDepartureDate(date);

        Trip trip = tripMapper.dtoToEntity(tripDTO);
        HashMap<StationDTO, List<Time>> map = timeTemplateDTO.getTemplateStation();
        Date currentDate = date;
        Time currentTime = map.get(stationList.get(0)).get(0); //arrival time for 1 station from route
        Date arrivalDate, departureDate;

        HashSet<Schedule> schedules = new HashSet<>();
        //create schedules for trip
        for (StationDTO station : stationList) {
            Time arrivalTime = map.get(station).get(0);
            Time departureTime = timeTemplateDTO.getTemplateStation().get(station).get(1);
            if (arrivalTime.before(currentTime)) {
                currentDate = new java.sql.Date(currentDate.getTime() + 24 * 60 * 60 * 1000);
            }
            arrivalDate = currentDate;
            currentTime = arrivalTime;
            //in last station schedule do not have departure time
            if (departureTime == null) {
                break;
            }
            if (departureTime.before(currentTime)) {
                currentDate = new java.sql.Date(currentDate.getTime() + 24 * 60 * 60 * 1000);

            }
            departureDate = currentDate;
            currentTime = departureTime;
            schedules.add(new Schedule(trip, arrivalDate, departureDate, stationMapper.dtoToEntity(station), arrivalTime, departureTime));
        }
        trip.setSchedules(schedules);
        //create seats for trip
        HashSet<Seat> seats = new HashSet<>();
        //we do not need last station from route
        List<Station> stations;
        if (stationList.size() >= 2) {
            stations = trip.getRoute().getStationList().subList(0, stationList.size() - 1);
        } else {
            stations = new ArrayList<>();
            stations.add(trip.getRoute().getStationList().get(0));
        }

        for (int i = 1; i <= tripDTO.getTrain().getNumberOfSeats(); i++) {
            Seat seat = new Seat();
            seat.setTrip(trip);
            seat.setNumber(i);
            HashSet<SeatStatus> seatStatuses = new HashSet<>();

            for (Station station : stations) {
                SeatStatus seatStatus = new SeatStatus();
                seatStatus.setStation(station);
                seatStatus.setSeat(seat);
                seatStatus.setAvailable(true);
                seatStatuses.add(seatStatus);
            }
            seat.setSeatStatuses(seatStatuses);
            seats.add(seat);
        }
        trip.setSeats(seats);
        tripDao.addtrip(trip);
    }

    @Override
    public List<ScheduleDTO> getSchedulesForTrip(int tripId) {
        return scheduleService.scheduleListForTrip(tripId);
    }

    @Override
    public List<TimeTemplateDTO> getTemplatesForRoute(int routeId) {
        return timeTemplateService.getTimeTemplateListForRoute(routeId);
    }

    @Override
    public RouteDTO getRouteById(int routeId) {
        return routeService.getRouteDTOById(routeId);
    }

    @Override
    public TrainDTO getTrainById(int trainId) {
        return trainService.getTrainDtoById(trainId);
    }

    @Override
    public TimeTemplateDTO getTimeTemplateById(int timeTemplateID) {
        return timeTemplateService.getTimeTemplateById(timeTemplateID);
    }

    @Override
    public List<TripDTO> listTripsInDay(Date date){
        return tripMapper.listEntityToDtoList(tripDao.listTripsInDay(date));
    }

    @Override
    public List<TripDTO> findRelevantTrips(String departureStationName, String arrivalStationName, Date date) {
        Station departStation = stationMapper.dtoToEntity(stationService.getStationByName(departureStationName));
        Station arrivalStation = stationMapper.dtoToEntity(stationService.getStationByName(arrivalStationName));
        List<TripDTO> resultTrips = new ArrayList<>();
        //find schedule which visit departStation in date
        List<ScheduleDTO> departSchedules = scheduleService.getScheduleFoStationIdDepartDate(departStation.getId(),date);
        List<Integer> tripsId = new ArrayList<>();// contains tripId which route visit depart station and arrive station
        if(departSchedules.size() > 0) {
            for (ScheduleDTO scheduleDTO : departSchedules) {
                TripDTO tripDTO = scheduleDTO.getTrip();
                Trip trip = tripMapper.dtoToEntity(tripDTO);
                Route route = trip.getRoute();
                if ((route.getStationList().contains(departStation)) && (route.getStationList()).contains(arrivalStation) &&
                        (route.getStationList().indexOf(departStation) < route.getStationList().indexOf(arrivalStation))) {
                    tripsId.add(trip.getId());
                }
            }
            //check trips which visit arrive station at this trip
            List<ScheduleDTO> arriveSchedules = scheduleService.getScheduleByTripsIdStationId(tripsId, arrivalStation.getId());


            for (ScheduleDTO schedule : arriveSchedules) {
                resultTrips.add(schedule.getTrip());
            }
        }
        return resultTrips;
    }

    @Override
    public List<StationDTO> getAllStation() {
        return this.stationService.listStations();
    }

    @Override
    public List<TicketForm> getScheduleBoardInfo(List<TripDTO> trips, String departStationName, String arriveStationName) {
        StationDTO departStation = stationService.getStationByName(departStationName);
        StationDTO arriveStation = stationService.getStationByName(arriveStationName);
        List<TicketForm> result = new ArrayList<>();
        for (TripDTO tripDTO : trips) {
            Trip trip = tripMapper.dtoToEntity(tripDTO);
            ScheduleDTO departSchedule = scheduleService.getScheduleByTripStation(tripDTO, departStation);
            ScheduleDTO arriveSchedule = scheduleService.getScheduleByTripStation(tripDTO, arriveStation);
            BigDecimal price = trip.getRoute().priceCalculate(stationMapper.dtoToEntity(departStation),stationMapper.dtoToEntity(arriveStation));
            result.add(new TicketForm(tripDTO.getTrain().getId(), tripDTO.getRoute().getName(), departSchedule.getDepartureDate(),
                    departSchedule.getDepartureTime(), arriveSchedule.getArrivalDate(), arriveSchedule.getArrivalTime(), price,tripDTO.getId(),departStation.getId(),arriveStation.getId() ) );
        }
        return result;
    }

    @Override
    public StationDTO getStationbyId(int id) {
        return stationService.getStationById(id);
    }
}
