package com.tsystems.railway.controller;

import com.tsystems.railway.model.Train;
import com.tsystems.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainControler {

    @Autowired
    private TrainService trainService;

    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }

    @RequestMapping(value = "trains",method = RequestMethod.GET)
    public String listTrains(Model model){
        model.addAttribute("train",new Train());
        model.addAttribute("listTrains",this.trainService.listTrains());
        return "trains";
    }

    @RequestMapping(value = "/trains", method = RequestMethod.POST)
    public String addTrain(@ModelAttribute("train") Train train){
        if (train.getId() == 0){

            trainService.addTrain(train);
        }else {
            trainService.updateTtain(train);
        }
        return "redirect:/trains";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.trainService.removeTrain(id);

        return "redirect:/trains";
    }

    @RequestMapping(value = "edit/{id}")
    public String editTrain(@PathVariable("id") int id, Model model){
       model.addAttribute("train",this.trainService.getTrainById(id));
       model.addAttribute("listTrains",this.trainService.listTrains());

       // this.trainService.updateTtain(this.trainService.getTrainById(id));
        return "trains";
    }



    @RequestMapping(value ="traindata/{id}",method = RequestMethod.GET)
    public String trainData(@PathVariable("id") long id,Model model){
        model.addAttribute("train",this.trainService.getTrainById(id));

        return "traindata";
    }


}
