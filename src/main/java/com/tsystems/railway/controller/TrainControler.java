package com.tsystems.railway.controller;

import com.tsystems.railway.entity.Train;
import com.tsystems.railway.service.TrainModelService;
import com.tsystems.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainControler {

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainModelService trainModelService;

    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }

    @RequestMapping(value = "trains",method = RequestMethod.GET)
    public String listTrains(Model model){
        model.addAttribute("train",new Train());
        model.addAttribute("listTrains",this.trainService.listTrains());
        model.addAttribute("listTrainModels",this.trainModelService.listTrainModels());
        return "trains";
    }

    @RequestMapping(value = "/train", method = RequestMethod.POST)
    public String addTrain(@ModelAttribute("train") Train train){
        if (train.getId() == 0){
            trainService.addTrain(train);
        }else {
            trainService.updateTtain(train);
        }
        return "redirect:/trains";
    }

    @RequestMapping("/remove/{id}")
    public String removeTrain(@PathVariable("id") int id){
        this.trainService.removeTrain(id);
        return "redirect:/trains";
    }

    @RequestMapping(value = "train/{id}" ,method = RequestMethod.PUT)
    public String editTrain(@PathVariable("id") int id, @ModelAttribute("train") Train train ,Model model){
        trainService.updateTtain(train);
       return "trains";
    }

    @RequestMapping(value = "train/{id}" ,method = RequestMethod.GET)
    public String getTrain(@PathVariable("id") int id, @ModelAttribute("train") Train train ,Model model){
       model.addAttribute("train", this.trainService.getTrainById(id));
        model.addAttribute("listTrainModels",this.trainModelService.listTrainModels());
        return "traindata";
    }

    @RequestMapping(value ="traindata/{id}",method = RequestMethod.GET)
    public String trainData(@PathVariable("id") int id,Model model){
        model.addAttribute("train",this.trainService.getTrainById(id));
        return "traindata";
    }
}
