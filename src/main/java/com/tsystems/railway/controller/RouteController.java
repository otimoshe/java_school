package com.tsystems.railway.controller;

import com.tsystems.railway.entity.Route;
import com.tsystems.railway.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;


    @RequestMapping(value = "routes", method = RequestMethod.GET)
    public String listRoutes(Model model) {
        model.addAttribute("route", new Route());
        model.addAttribute("listRoutes", this.routeService.getRouteList());


        return "routes";
    }

    @RequestMapping(value = "/routes", method = RequestMethod.POST)
    public String addRoute(@ModelAttribute("route") Route route) {
        if (route.getId() == 0) {

            routeService.addRoute(route);
        } else {
            routeService.updateRoute(route);
        }
        return "redirect:/routes";
    }

    @RequestMapping("/removeRoute/{id}")
    public String removeTrain(@PathVariable("id") int id) {
        this.routeService.deleteRoute(id);

        return "redirect:/route";
    }


}
