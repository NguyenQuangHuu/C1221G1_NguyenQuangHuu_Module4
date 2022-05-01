package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/homepage")
    public String homepage(){
        return "/homepage";
    }


    @GetMapping("/currency")
    public String currency(@RequestParam Integer usd, Model model){
        model.addAttribute("vnd",usd*23000);
        return "/result";
    }
}
