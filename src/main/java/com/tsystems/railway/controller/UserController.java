package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.User;
import com.tsystems.railway.mappers.PassengerMapper;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TripService tripService;

    @Autowired
    SeatService seatService;

    @Autowired
    StationService stationService;

    @Autowired
    PassengerMapper passengerMapper;
    
    @Autowired
    RouteMapper routeMapper;
    
    @Autowired
    StationMapper stationMapper;

    @Autowired
    UserService userService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    BuyTicketService buyTicketService;

    @RequestMapping(value = "/tripList", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("ticket" , new TicketDTO());
        model.addAttribute("listTrips", this.tripService.listTripDTOs());

        return "tripList";
    }

    @RequestMapping(value = ("buyTicket/{id}"), method = RequestMethod.GET)
    public String ticket(@PathVariable("id") int tripId, Model model) {
        model.addAttribute("trip", this.tripService.getTripById(tripId));
        model.addAttribute("stationList",this.tripService.getTripById(tripId).getRoute().getStationList());
        model.addAttribute("seatsList", seatService.getAvailableSeatForTrip(tripId, tripService.getTripById(tripId).getRoute().getFirstStation(), tripService.getTripById(tripId).getRoute().getStationList().get(tripService.getTripById(tripId).getRoute().getStationList().size() - 1)));

        return "buyTicket";
    }


    @RequestMapping(value = ("/buyForTrip/{id}"), method = RequestMethod.POST)
    public String buyTicket( Model model,
                             @PathVariable("id") int tripId,
                             @ModelAttribute("seatId") Integer seatId,
                             @ModelAttribute("departId") Integer departId,
                             @ModelAttribute("arriveId") Integer arriveId) {


        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        PassengerDTO passenger = passengerMapper.entityToDto(user.getPassengers().stream().findFirst().get());
        TripDTO trip = tripService.getTripById(tripId);
        StationDTO departureStation = stationService.getStationById(departId);
        StationDTO arrivalStation = stationService.getStationById(arriveId);
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

    @RequestMapping(value = "/userSchedule",method = RequestMethod.GET)
    public String userSchedule(Model model){
        model.addAttribute("stationList",stationService.listStations());

        return "userSchedule";
    }

    @RequestMapping(value = "/userSchedule", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public List<ScheduleDTO> ajaxTest(@RequestBody StationScheduleDTO stationScheduleDTO, Model model ) {
        int stationId = stationScheduleDTO.getStationId();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(stationScheduleDTO.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(parsed.getTime());
        buyTicketService.findRelevantTrips("a", "c", date);
        return scheduleService.getScheduleListForStation(stationId,date);
    }

    @RequestMapping(value = "/tripSchedule",method = RequestMethod.GET)
    public String tripSchedule(Model model,int stationId,Date date){
        model.addAttribute("scheduleList",scheduleService.getScheduleListForStation(stationId,date));
        return "userSchedule";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getMainPage(Model model){
        return "index";
    }

}
