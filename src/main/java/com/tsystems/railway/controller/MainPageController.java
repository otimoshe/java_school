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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
@SessionAttributes(types = TicketForm.class)
public class MainPageController {

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

  /*  @RequestMapping(value = "/tripList", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("ticket" , new TicketDTO());
        model.addAttribute("listTrips", this.tripService.listTripDTOs());
        model.addAttribute("stations",tripService.getAllStation());
        return "tripList";
    }*/

    @RequestMapping(value = ("/buyTicket/seat"), method = RequestMethod.POST)
    public String ticket( Model model,TicketForm ticketForm) {
        model.addAttribute("passengerList",);

        return "passenger";
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
       return "";
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
        return scheduleService.getScheduleListForStation(stationId,date);
    }

    @RequestMapping(value = "/tripSchedule",method = RequestMethod.GET)
    public String tripSchedule(Model model,int stationId,Date date){
        model.addAttribute("scheduleList",scheduleService.getScheduleListForStation(stationId,date));
        return "userSchedule";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getMainPage(Model model){
        model.addAttribute("stations",tripService.getAllStation());
        return "index";
    }
    @RequestMapping(value = "/findTrips",method = RequestMethod.GET)
    public String findRelevantTrip(Model model,@RequestParam("departStation") String departureStationName, @RequestParam("arriveStation")String arrivalStationName, @RequestParam("date")Date date){
        List<TripDTO> tripList = this.tripService.findRelevantTrips(departureStationName,arrivalStationName,date);
        model.addAttribute("searchResult",this.tripService.getScheduleBoardInfo(tripList,departureStationName,arrivalStationName));
        model.addAttribute("ticketForm", new TicketForm());
        return "tripList";
    }

    @RequestMapping(value = ("buyTicket"), method = RequestMethod.POST)
    public String buyTicket(Model model,@ModelAttribute("ticketForm") TicketForm ticketForm){
        StationDTO departStation = stationService.getStationById(ticketForm.getDepartStationId());
        StationDTO arriveStation = stationService.getStationById(ticketForm.getArriveStationId());
        model.addAttribute("seatsList", seatService.getAvailableSeatForTrip(ticketForm.getTripId(),departStation,arriveStation));
        return "buyTicketSeat";
    }

}
