package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.entity.User;
import com.tsystems.railway.mappers.PassengerMapper;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.service.SeatService;
import com.tsystems.railway.service.TicketService;
import com.tsystems.railway.service.TripService;
import com.tsystems.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TripService tripService;

    @Autowired
    SeatService seatService;

    @Autowired
    PassengerMapper passengerMapper;
    
    @Autowired
    RouteMapper routeMapper;
    
    @Autowired
    StationMapper stationMapper;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/tripList", method = RequestMethod.GET)
    public String listTrips(Model model) {
     //   model.addAttribute("ticket" , new TicketDTO());
        model.addAttribute("listTrips", this.tripService.listTripDTOs());

        return "tripList";
    }

    @RequestMapping(value = ("buyTicket/{id}"), method = RequestMethod.GET)
    public String ticket(@PathVariable("id") int tripId, Model model) {
        model.addAttribute("trip", this.tripService.getTripById(tripId));

        model.addAttribute("seatsList", seatService.getAvailableSeatForTrip(tripId, tripService.getTripById(tripId).getRoute().getFirst_station(), tripService.getTripById(tripId).getRoute().getStationList().get(tripService.getTripById(tripId).getRoute().getStationList().size() - 1)));
        return "buyTicket";
    }


    @RequestMapping(value = ("/buyForTrip/{id}"), method = RequestMethod.POST)
    public String buyTicket( Model model,
                             @PathVariable("id") int tripId,
                             @ModelAttribute("seatId") Integer seatId) {


        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        PassengerDTO passenger = passengerMapper.entityToDto(user.getPassengers().stream().findFirst().get());
        TripDTO trip = tripService.getTripById(tripId);
        StationDTO departureStation = trip.getRoute().getFirst_station();
        StationDTO arrivalStation = trip.getRoute().getStationList().get(trip.getRoute().getStationList().size() - 1);
        Date departureDate = trip.getDepartureDate();
        Date arrivalDate = trip.getDepartureDate();
        BigDecimal price = trip.getRoute().getPrice();
        SeatDTO seat =  seatService.getSeatById(seatId);

        TicketDTO ticket = new TicketDTO();
        ticket.setPassenger(passenger);
        ticket.setTrip(trip);
        ticket.setDepartureStation(departureStation);
        ticket.setArrivalStation(arrivalStation);
        ticket.setArrivalDate(arrivalDate);
        ticket.setDepartureDate(departureDate);
        ticket.setPrice(price);

        //change seatStatus for our seat

        //TODO 
        LinkedHashMap<StationDTO,Boolean> statuses = seat.getStatuses();
        List<StationDTO> stationList = stationMapper.listEntityToDtoList(routeMapper.dtoToEntity(trip.getRoute()).getSubRoute(stationMapper.dtoToEntity(departureStation),stationMapper.dtoToEntity(arrivalStation)));
        for(StationDTO station:stationList){
            statuses.replace(station,false);
        }

      //  seatService.updateSeat(seat);
        ticket.setSeat( seat);
       // seat.setStatuses(statuses);

        ticketService.addTicket(ticket);
        return "tripList";
    }

}
