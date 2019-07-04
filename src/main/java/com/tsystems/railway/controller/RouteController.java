package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.service.PathService;
import com.tsystems.railway.service.RouteService;
import com.tsystems.railway.service.StationService;
import com.tsystems.railway.validator.RouteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private StationService stationService;

    @Autowired
    private PathService pathService;

    @Autowired
    private RouteValidator routeValidator;

    @RequestMapping(value = "routes", method = RequestMethod.GET)
    public String listRoutes(Model model) {
        model.addAttribute("route", new RouteDTO());
        model.addAttribute("listPaths",this.pathService.getPathList());
        model.addAttribute("listStations",this.stationService.listStations());
        model.addAttribute("listRoutes", this.routeService.getRouteList());
        model.addAttribute("dto", new AddRouteForm());
        return "routes";
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public String addRoute(@ModelAttribute("dto") AddRouteForm form,Model model,BindingResult bindingResult) {
        model.addAttribute("listRoutes", this.routeService.getRouteList());
        model.addAttribute("listPaths",this.pathService.getPathList());
        model.addAttribute("listStations",this.stationService.listStations());
         routeValidator.validate(this.routeService.routeDTOfromRouteFormDTO(form),bindingResult);
        if (bindingResult.hasErrors()) {
            return "routes";
        }
        routeService.addRoute(form);
        return "redirect:/routes";
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public String getRoute(@PathVariable("id") int id,  Model model) {
        model.addAttribute("route", this.routeService.getRouteDTOById(id));
        model.addAttribute("listRoutes", this.routeService.getRouteList());
        return "routeData";
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.POST)
    public String editRoute(@PathVariable("id") int id,@ModelAttribute("route") RouteDTO route) {
        RouteDTO oldRoute = routeService.getRouteDTOById(id);
        oldRoute.setName(route.getName());
        oldRoute.setPrice(route.getPrice());
        routeService.updateRoute(oldRoute);
        return "redirect:/routes";
    }

    @RequestMapping(value = "/remove/route/{id}")
    public String removeRoute(@PathVariable("id") int id) {
        this.routeService.deleteRoute(id);
        return "redirect:/routes";
    }

    @RequestMapping(value = "/paths", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public List<PathDTO> getAvailablePaths(@RequestBody StationDTO station){

        return pathService.pathsForStation(station.getId());

    }
}
