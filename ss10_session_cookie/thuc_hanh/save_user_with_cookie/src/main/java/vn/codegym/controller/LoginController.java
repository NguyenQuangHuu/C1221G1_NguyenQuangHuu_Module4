package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Users;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @ModelAttribute("users")
    public Users userForm(){
        return new Users();
    }

    @GetMapping("/login")
    public String loginForm(Model model, @CookieValue(value="setUser",defaultValue = "") String setUser){
        Cookie cookie = new Cookie("setUser",setUser);
        model.addAttribute("cookieValue",cookie);
        return "/login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse,
                        HttpServletRequest  httpServletRequest,
                        @ModelAttribute Users users, Model model, @CookieValue(value = "setUser",defaultValue = "") String setUser){
        if(users.getName().equals("admin@gmail.com") && users.getPassword().equals("123456")){
            if(users.getName()!=null){
                setUser = users.getName();
            }

            Cookie cookie = new Cookie("setUser",setUser);
            cookie.setMaxAge(60);
            httpServletResponse.addCookie(cookie);

            Cookie[] cookies = httpServletRequest.getCookies();
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            users.setName("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
