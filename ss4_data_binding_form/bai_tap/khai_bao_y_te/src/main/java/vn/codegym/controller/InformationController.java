package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Information;

@Controller
public class InformationController {

    @GetMapping("/information-form")
    public String informationForm(Model model){
        model.addAttribute("information",new Information());
        return "/index";
    }

    @PostMapping("/information-review")
    public String reviewInformation(@ModelAttribute Information information,Model model){
        model.addAttribute("information2",information);
        return "/review";
    }

    @PostMapping("/edit")
    public String editInformation(@ModelAttribute("information2") Information information, Model model){
        model.addAttribute("information",information);
        System.out.println(information);
        return "/index";
    }
}
