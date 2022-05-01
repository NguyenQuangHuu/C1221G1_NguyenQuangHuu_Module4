package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;

@Controller
public class CalculatorController {

    @GetMapping("/homepage")
    public String homepage(){
        return "/index";
    }


    @PostMapping("/homepage")
    public String calculate(Model model, @RequestParam String leftNumber, @RequestParam String rightNumber, @RequestParam String operator) {
        Integer result = null;
        Integer numberOne = Integer.parseInt(leftNumber);
        Integer numberTwo = Integer.parseInt(rightNumber);

        switch (operator) {
            case "Addition(+)":
                result = numberOne + numberTwo;
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo;
                break;
            case "Multiplication(*)":
                result = numberOne * numberTwo;
                break;
            case "Divide(/)":
                result = numberOne / numberTwo;
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("operator",operator);
        return "/index";
    }
}
