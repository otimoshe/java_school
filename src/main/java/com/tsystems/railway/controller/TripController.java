package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.service.*;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SeatService seatService;

    @RequestMapping(value = "trips", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("trip", new TripDTO());
        model.addAttribute("routeId", new Integer(0));
        model.addAttribute("trainId", new Long(0));
        model.addAttribute("listTrips", this.tripService.listTripDTOs());
        model.addAttribute("routeList", this.routeService.getDtoRouteList());
        model.addAttribute("trainList", this.trainService.listTrainDTOs());

        return "trips";
    }

    @Transactional
    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip") TripDTO tripDTO,
                          @ModelAttribute("routeId") Integer routeID,
                          @ModelAttribute("trainId") Integer trainId) {

        tripDTO.setRoute(routeService.getRouteDTOById(routeID));
        tripDTO.setTrain(trainService.getTrainDtoById(trainId));
        tripService.addTrip(tripDTO);

        return "redirect:/trips";
    }

    @RequestMapping("/removeTrip/{id}")
    public String removeTrip(@PathVariable("id") int id) {
        this.tripService.deleteTrip(id);

        return "redirect:/trips";
    }

    @Transactional
    @RequestMapping(value = "tripSchedule/{id}", method = RequestMethod.GET)
    public String schedule(@PathVariable("id") int tripId, Model model) {
        if (this.scheduleService.scheduleListForTrip(tripId).size() == 0) {
            // generate schedules for trip
            TripDTO trip = tripService.getTripById(tripId);
            RouteDTO route = trip.getRoute();
            List<StationDTO> stationList = route.getStationList();

            for (StationDTO station : stationList) {
                scheduleService.addSchedule(new ScheduleDTO(trip, trip.getDepartureDate(), trip.getDepartureDate(), station));
            }
        }
        model.addAttribute("scheduleList", this.scheduleService.scheduleListForTrip(tripId));

        return "schedule";
    }

    @Transactional
    @RequestMapping(value = "tripSeats/{id}", method = RequestMethod.GET)
    public String seats(@PathVariable("id") int tripId, Model model) {
        if (this.seatService.getAllSeatsForTrip(tripId).size() == 0) {
            TripDTO tripDTO = tripService.getTripById(tripId);
            for ( int i = 1;i <=tripDTO.getTrain().getNumberOfSeats();i++){
                LinkedHashMap<StationDTO,Boolean> statuses = new LinkedHashMap<>();
                for (StationDTO stationDTO: tripDTO.getRoute().getStationList()){
                    statuses.put(stationDTO,true);
                }

               seatService.addSeat( new SeatDTO(tripDTO,i,statuses));
            }
        }
        model.addAttribute("seatsList", this.seatService.getAllSeatsForTrip(tripId));

        return "seats";
    }


}

