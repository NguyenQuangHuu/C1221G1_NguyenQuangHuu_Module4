package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.dto.UserDto;
import vn.codegym.model.User;
import vn.codegym.service.IUserService;

@Controller
public class FormController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "index";
    }

    @PostMapping("/register")
    public String registerFormSubmit(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,Model model){
        new UserDto().validate(userDto,bindingResult);

        if(bindingResult.hasFieldErrors()){
            return "index";
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            this.iUserService.save(user);
            model.addAttribute("user",user);
            return "result";
        }
    }
}
