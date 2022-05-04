package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.service.ICalculatorService;


@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService service;

    @GetMapping("/index")
    public String homepage(){
        return "/index";
    }


    @PostMapping("/index")
    public String calculate(Model model, @RequestParam String leftNumber, @RequestParam String rightNumber, @RequestParam String operator) {
        Double result = null;
        String message = null;
        try{
            switch (operator) {
                case "Addition(+)":
                    result = this.service.sum(leftNumber,rightNumber);
                    break;
                case "Subtraction(-)":
                    result = this.service.sub(leftNumber,rightNumber);
                    break;
                case "Multiplication(*)":
                    result = this.service.multi(leftNumber,rightNumber);
                    break;
                case "Divide(/)":
                    result = this.service.div(leftNumber,rightNumber);
                    break;
            }
        }catch (NumberFormatException numberFormatException){
            message = "Chỉ nhập số";
        } catch (Exception e) {
            message = e.getMessage();
        }

        model.addAttribute("result", result);
        model.addAttribute("operator",operator);
        model.addAttribute("message",message);
        return "/index";
    }
}
