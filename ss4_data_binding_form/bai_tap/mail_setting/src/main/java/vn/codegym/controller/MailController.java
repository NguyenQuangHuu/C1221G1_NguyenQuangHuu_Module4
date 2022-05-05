package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.MailSetting;

@Controller
public class MailController {
    @GetMapping("/index")
    public String showForm(Model model){
        model.addAttribute("mailSetting",new MailSetting());
        return "index";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute MailSetting mailSetting, Model model){
        model.addAttribute("mail",mailSetting);
        return "result";
    }
}
