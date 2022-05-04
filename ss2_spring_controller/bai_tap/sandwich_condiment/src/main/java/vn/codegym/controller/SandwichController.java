package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SandwichController {

    @GetMapping("/homepage")
    public ModelAndView condimentView(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @PostMapping("/info")
    public ModelAndView infoSubmit(@RequestParam Optional<String[]> condiments  ){
        ModelAndView modelAndView =  new ModelAndView("/info");
        if(condiments.isPresent()){
            modelAndView.addObject("condiments",condiments);
        }else{
            modelAndView.addObject("message","NONNNNNNNN!");
        }
        return modelAndView;
    }
}
