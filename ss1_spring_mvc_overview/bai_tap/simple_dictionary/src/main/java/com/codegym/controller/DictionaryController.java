package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import com.codegym.service.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService service;

    @GetMapping("/dictionary")
    public String dictionaryPage(){
        return "homepage";
    }

    @GetMapping("/translate")
    public String translateResult(@RequestParam String eng, Model model){
        String result = this.service.translateResult(eng);
        if(result.equals("")){
            result = "Không tìm thấy kết quả này";
        }

        model.addAttribute("result",result);
        model.addAttribute("eng",eng);
        return "translate";
    }
}
