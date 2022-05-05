package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Login;
import vn.codegym.model.User;
import vn.codegym.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public ModelAndView homepage(){
        return new ModelAndView("/home","login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = this.userService.checkLogin(login);
        if(user != null){
            return new ModelAndView("user","user",user);
        }else{
            return new ModelAndView("error");
        }
    }
}
