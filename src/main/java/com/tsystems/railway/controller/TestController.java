package com.tsystems.railway.controller;


import com.tsystems.railway.entity.Train;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("train",new Train());
        return "test";
    }

    @RequestMapping(value = "/one",method = RequestMethod.POST)
    public String post(@ModelAttribute Train train, Model model){
        model.addAttribute("train",train);
        return "result";
    }

    @RequestMapping(value = "/one",method = RequestMethod.GET  )
    public String get(@ModelAttribute Train train, Model model){
        model.addAttribute("train",train);
        return "redirect:test";
    }

   // @RequestMapping(value = "/result")
  //  public String result(@ModelAttribute Train train, Model entity){
   //     return "result";
   // }

}
