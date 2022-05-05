package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Information;

@Controller
public class InformationController {

    @GetMapping("/information-form")
    public String informationForm(Model model){
        model.addAttribute("information",new Information());
        return "/index";
    }
}
