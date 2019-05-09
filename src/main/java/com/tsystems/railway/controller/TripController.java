package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.Trip;
import com.tsystems.railway.mappers.TripMapper;
import com.tsystems.railway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "trips", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("trip", new TripDTO());
        model.addAttribute("routeId", new Integer(0));
        model.addAttribute("trainId", new Long(0));
        model.addAttribute("listTrips", this.tripService.listTripDTOs());
        model.addAttribute("routeList", this.tripService.getAllRoutes());
        model.addAttribute("trainList", this.tripService.getAllTrains());

        return "trips";
    }


    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip") TripDTO tripDTO,
                          @ModelAttribute("routeId") Integer routeID,
                          @ModelAttribute("trainId") Integer trainId,
                          @ModelAttribute("templateId") Integer templateId) {

      this.tripService.createTrip(routeID,templateId,tripDTO.getDepartureDate(),trainId);

        return "redirect:/trips";
    }

    @RequestMapping("/removeTrip/{id}")
    public String removeTrip(@PathVariable("id") int id) {
        this.tripService.deleteTrip(id);
        return "redirect:/trips";
    }

    @Transactional
    @RequestMapping(value = "trip/schedule/{id}", method = RequestMethod.GET)
    public String schedule(@PathVariable("id") int tripId, Model model) {
        model.addAttribute("scheduleList", this.tripService.getSchedulesForTrip(tripId));

        return "schedule";
    }



    @RequestMapping(value = "tripTickets/{id}", method = RequestMethod.GET)
    public String tickets(@PathVariable("id") int tripId, Model model) {
        model.addAttribute("ticketList", this.ticketService.getTicketsForTrip(tripId));
        return "tickets";
    }

    @RequestMapping(value = "/routeId", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public List<TimeTemplateDTO> getRouteId(@RequestBody RouteDTO route){
        return tripService.getTemplatesForRoute(route.getId());

    }
}

