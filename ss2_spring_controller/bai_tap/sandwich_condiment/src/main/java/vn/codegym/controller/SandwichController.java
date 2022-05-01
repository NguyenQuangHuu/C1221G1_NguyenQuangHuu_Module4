package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("/homepage")
    public ModelAndView condimentView(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @PostMapping("/info")
    public ModelAndView infoSubmit(@RequestParam String[] condiments){
        ModelAndView modelAndView =  new ModelAndView("/info");
        modelAndView.addObject("condiments",condiments);
        return modelAndView;
    }
}
