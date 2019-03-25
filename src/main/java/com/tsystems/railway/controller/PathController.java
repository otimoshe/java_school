package com.tsystems.railway.controller;


import com.tsystems.railway.model.Path;

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
        model.addAttribute("path",new Path());
        model.addAttribute("listPaths",this.pathService.getPathList());
        model.addAttribute("listStations",this.stationService.listStations());

        return "paths";
    }

    @RequestMapping(value = "/paths", method = RequestMethod.POST)
    public String addPath(@ModelAttribute("path") Path path){

        if (path.getId() == 0){

            pathService.addPath(path);
        }else {
            pathService.addPath(path);
        }

        return "redirect:/paths";
    }

    @RequestMapping("/paths/remove/{id}")
    public String removePath(@PathVariable("id") int id){
        this.pathService.deletePath(id);

        return "redirect:/paths";
    }

}
