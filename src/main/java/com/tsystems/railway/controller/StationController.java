package com.tsystems.railway.controller;


import com.tsystems.railway.model.Station;
import com.tsystems.railway.model.Train;
import com.tsystems.railway.service.StationService;
import com.tsystems.railway.service.TrainService;
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
        model.addAttribute("station",new Station());
        model.addAttribute("listStations",this.stationService.listStations());
        return "stations";
    }

    @RequestMapping(value = "/stations", method = RequestMethod.POST)
    public String addStation(@ModelAttribute("station") Station station){
        if (station.getId() == 0){

            stationService.addStation(station);
        }else {
            stationService.updateStation(station);
        }
        return "redirect:/stations";
    }

    @RequestMapping("/removeStation/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.stationService.deleteStation(id);

        return "redirect:/stations";
    }

}
