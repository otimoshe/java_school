package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TripController {

    @Autowired
    public TripService tripService;

    @RequestMapping(value = "trips",method = RequestMethod.GET)
    public String listTrips(Model model){
        model.addAttribute("trip",new TripDTO());
        model.addAttribute("listTrips",this.tripService.listTripDTOs());
        return "trips";
    }

    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("station") TripDTO tripDTO){
        tripService.addTrip(tripDTO);
        return "redirect:/trips";
    }

    @RequestMapping("/removeTrip/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.tripService.deleteTrip(id);

        return "redirect:/trips";
    }

}

