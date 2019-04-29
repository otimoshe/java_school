package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Train;
import com.tsystems.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "stations",method = RequestMethod.GET)
    public String listStations(Model model){
        model.addAttribute("station",new StationDTO());
        model.addAttribute("listStations",this.stationService.listStations());
        return "stations";
    }

    @RequestMapping(value = "/station", method = RequestMethod.POST)
    public String addStation(@ModelAttribute("station") StationDTO station){
        if (station.getId() == 0){
            stationService.addStation(station);
        }else {
            stationService.updateStation(station);
        }
        return "redirect:/stations";
    }

    @RequestMapping("/removeStation/{id}")
    public String removeStation(@PathVariable("id") int id){
        this.stationService.deleteStation(id);
        return "redirect:/stations";
    }

    @RequestMapping(value = "station/{id}" ,method = RequestMethod.GET)
    public String getTrain(@PathVariable("id") int id, @ModelAttribute("train") Train train , Model model) {
        model.addAttribute("station", this.stationService.getStationById(id));
        model.addAttribute("listStations",this.stationService.listStations());
        return "stationdata";
    }
}
