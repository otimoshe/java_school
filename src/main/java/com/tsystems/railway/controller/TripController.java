package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.service.RouteService;
import com.tsystems.railway.service.TrainService;
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
    private TripService tripService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "trips",method = RequestMethod.GET)
    public String listTrips(Model model){
        model.addAttribute("trip",new TripDTO());
        model.addAttribute("train", new TrainDTO());
        model.addAttribute("route",new RouteDTO());
        model.addAttribute("routeId",new Integer(0));
        model.addAttribute("listTrips",this.tripService.listTripDTOs());
        model.addAttribute("routeList",this.routeService.getDtoRouteList());
        model.addAttribute("trainList",this.trainService.listTrainDTOs());

        return "trips";
    }


    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip") TripDTO tripDTO ,
                          @ModelAttribute("routeId") Integer routeID){
                      //    @ModelAttribute("route") RouteDTO routeDTO){

       tripDTO.setRoute( routeService.getRouteDTOById(routeID));
     //   tripDTO.setTrain(trainDTO);

        tripService.addTrip(tripDTO);
        return "redirect:/trips";
    }

    @RequestMapping("/removeTrip/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.tripService.deleteTrip(id);

        return "redirect:/trips";
    }

}

