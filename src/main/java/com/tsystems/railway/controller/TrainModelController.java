package com.tsystems.railway.controller;

import com.tsystems.railway.entity.TrainModel;
import com.tsystems.railway.service.TrainModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrainModelController {

    @Autowired
    private TrainModelService trainModelService;

    @RequestMapping(value = "trainModels",method = RequestMethod.GET)
    public String listModels(Model model){
        model.addAttribute("model",new TrainModel());
        model.addAttribute("listTrainModels",this.trainModelService.listTrainModels());
        return "trainModels";
    }

    @RequestMapping("/removeModel/{id}")
    public String removeModel(@PathVariable("id") int id){
        this.trainModelService.removeTrainModel(id);

        return "redirect:/trainModels";
    }
    @RequestMapping(value = "editModel/{id}")
    public String editModel(@PathVariable("id") int id, Model model){
        model.addAttribute("train",this.trainModelService.getTrainModelById(id));
        model.addAttribute("listTrains",this.trainModelService.listTrainModels());
        return "trains";
    }

    @RequestMapping(value = "/trainModels", method = RequestMethod.POST)
    public String addTrainModel(@ModelAttribute("model") TrainModel trainModel){
        if (trainModel.getId() == 0){

            trainModelService.addTrainModel(trainModel);
        }else {
            trainModelService.updateTrainModel(trainModel);
        }
        return "redirect:/trainModels";
    }

}
