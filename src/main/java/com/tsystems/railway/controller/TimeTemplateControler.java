package com.tsystems.railway.controller;

import com.tsystems.railway.entity.Train;
import com.tsystems.railway.service.TimeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimeTemplateControler {

    @Autowired
    TimeTemplateService timeTemplateService;

    @RequestMapping(value = "templates",method = RequestMethod.GET)
    public String listTemplates(Model model){
        model.addAttribute("listTemplates",this.timeTemplateService.geTimetemplatesList());
        return "templates";
    }

    @RequestMapping("/removeTemplate/{id}")
    public String removeTemplate(@PathVariable("id") int id){
       this.timeTemplateService.deleteTimeTemplate(id);
       return "redirect:/templates";
    }

    @RequestMapping(value ="templateInfo/{id}",method = RequestMethod.GET)
    public String templateData(@PathVariable("id") int id,Model model){
        model.addAttribute("TemplateStationSet", timeTemplateService.getTimeTemplateById(id).getTemplateStation());
        return "templateData";
    }
}
