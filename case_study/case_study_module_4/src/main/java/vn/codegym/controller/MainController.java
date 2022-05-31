package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login-page";
    }

    @PostMapping("/login")
    public String loginPage(Principal principal){
        return "login-page";
    }

    @GetMapping("/log-out")
    public String logoutPage(){
        return "log-out-page";
    }

    @GetMapping("/403-page")
    public String errorPage(){
        return "403-page";
    }

    @GetMapping("/log-out-success")
    public String logoutSuccessPage(){
        return "log-out-success";
    }

    @ExceptionHandler(Exception.class)
    public String error(){
        return "403-page";
    }
}
