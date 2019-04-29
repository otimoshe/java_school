package com.tsystems.railway.controller;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.service.RouteService;
import com.tsystems.railway.service.StationService;
import com.tsystems.railway.service.TimeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.Time;
import java.util.*;

@Controller
public class TimeTemplateControler {

    @Autowired
    TimeTemplateService timeTemplateService;

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;

    @RequestMapping(value = "templates",method = RequestMethod.GET)
    public String listTemplates(Model model){
        model.addAttribute("template",new TimeTemplateDTO());
        model.addAttribute("listTemplates",this.timeTemplateService.geTimetemplatesList());
        model.addAttribute("routesList",this.routeService.getDtoRouteList());
        return "templates";
    }

    @RequestMapping("/removeTemplate/{id}")
    public String removeTemplate(@PathVariable("id") int id){
       this.timeTemplateService.deleteTimeTemplate(id);
       return "redirect:/templates";
    }


    @RequestMapping(value ="templateTimeInfo/{id}",method = RequestMethod.GET)
    public String templateData(@PathVariable("id") Integer id,Model model){
        model.addAttribute("TemplateStationSet", timeTemplateService.getTimeTemplateById(id).getTemplateStation());
        HashMap<StationDTO,List<Time>> times = timeTemplateService.getTimeTemplateById(id).getTemplateStation();
        HashMap<String,List<String>> map = new HashMap<>();
        for (Map.Entry<StationDTO, List<Time>> entry : times.entrySet()) {
            List<String>  timeList = new ArrayList<>();
            for(Time time: entry.getValue() ){
                if (time == null){
                    timeList.add("");
                } else {
                    timeList.add(time.toString());
                }
            }
            map.put(entry.getKey().getName(),timeList);
        }

        model.addAttribute("times",new TimeTemplatesForm(id,map));
        return "templateTimeInfo";
    }

    @RequestMapping(value = "/addTemplate",method = RequestMethod.POST)
    public String addTemplate(@ModelAttribute("template") TimeTemplateDTO template,Integer routeId ) {
        RouteDTO route = this.routeService.getRouteDTOById(routeId);
        template.setRoute(route);
        HashMap<StationDTO, List<Time>> templates = new HashMap<>();
        ArrayList<Time> time = new ArrayList<>();
        time.add(null);
        time.add(null);
        for(StationDTO stationDTO:route.getStationList()){
            templates.put(stationDTO,time);
        }
        template.setTemplateStation(templates);
        timeTemplateService.addTimeTemplate(template);
        return "redirect:/templates";
    }

    @RequestMapping(value ="templateInfo/{id}",method = RequestMethod.POST)
    public String timeUpdate( @ModelAttribute("times") TimeTemplatesForm times ){
        TimeTemplateDTO timeTemplate =  timeTemplateService.getTimeTemplateById(times.getTemplateId());
        HashMap<StationDTO, List<Time>> stationTimesMap = timeTemplate.getTemplateStation();
        for (Map.Entry<String, List<String>> entry : times.getTemplateStationMap().entrySet()) {
            List<Time> newTimes = new ArrayList<>();
            for (String time: entry.getValue()) {
                if (time.length() == 5)
                    time = time.concat(":00");
                if (time.equals("")){
                    newTimes.add(null);
                }else
                    newTimes.add(java.sql.Time.valueOf(time));
            }
            stationTimesMap.put(stationService.getStationByName(entry.getKey()),newTimes);
        }
        timeTemplate.setTemplateStation(stationTimesMap);
        timeTemplateService.updateTimeTemplate(timeTemplate);
        return "templateTimeInfo";
    }

    @RequestMapping(value = "template/{id}" ,method = RequestMethod.GET)
    public String gettemplateInfo(@PathVariable("id") int id,  Model model){
        model.addAttribute("template", this.timeTemplateService.getTimeTemplateById(id));
        return "templateData";
    }

    @RequestMapping(value = "template/{id}" ,method = RequestMethod.POST)
    public String updateTemplate(@PathVariable("id") int id,@ModelAttribute("template") TimeTemplateDTO template){
        TimeTemplateDTO oldTemplate = this.timeTemplateService.getTimeTemplateById(id);
        oldTemplate.setName(template.getName());
        timeTemplateService.updateTimeTemplate(oldTemplate);
        return "redirect:/templates";
    }
}
