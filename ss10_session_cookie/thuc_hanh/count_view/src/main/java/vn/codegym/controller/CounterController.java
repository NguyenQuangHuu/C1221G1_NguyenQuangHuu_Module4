package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Counter;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter counterInstance(){
        Counter counter = new Counter();
        counter.setCount(0);
        return counter;
    }

    @GetMapping("/")
    public String get(@ModelAttribute Counter counter){
        counter.setCount(counter.getCount()+1);
        return "/index";
    }
}
