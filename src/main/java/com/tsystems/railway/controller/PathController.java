package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.entity.Path;
import com.tsystems.railway.service.PathService;
import com.tsystems.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PathController {

    @Autowired
    PathService pathService;

    @Autowired
    StationService stationService;



    @RequestMapping(value = "paths",method = RequestMethod.GET)
    public String listPaths(Model model){
        model.addAttribute("path",new PathDTO());
        model.addAttribute("listPaths",this.pathService.getPathList());
        model.addAttribute("listStations",this.stationService.listStations());
        model.addAttribute("stationId", new Integer(0));
        model.addAttribute("nextStationId", new Integer(0));
        model.addAttribute("distance",new Double(0));
        return "paths";
    }

    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public String addPath(@ModelAttribute("path") PathDTO path,
                          @ModelAttribute("stationId") Integer stationId,
                          @ModelAttribute("nextStationId") Integer nextStationId){
        path.setStation(stationService.getStationById(stationId));
        path.setNextStation( stationService.getStationById(nextStationId));
        pathService.addPath(path);
        return "redirect:/paths";
    }

    @RequestMapping("/path/remove/{id}")
    public String removePath(@PathVariable("id") int id){
        this.pathService.deletePath(id);
        return "redirect:/paths";
    }

    @RequestMapping(value = "path/{id}" ,method = RequestMethod.GET)
    public String getPathInfo(@PathVariable("id") int id,  Model model){
        model.addAttribute("path", this.pathService.getPathById(id));
       // model.addAttribute("distance",this.pathService.getPathById(id).getDistance());
        return "pathData";
    }

    @RequestMapping(value = "path/{id}" ,method = RequestMethod.POST)
    public String updatePath(@PathVariable("id") int id,@ModelAttribute("distance") double distance){
        PathDTO path = pathService.getPathById(id);
        path.setDistance(distance);
        pathService.updatePath(path);
        return "redirect:/paths";
    }

}
