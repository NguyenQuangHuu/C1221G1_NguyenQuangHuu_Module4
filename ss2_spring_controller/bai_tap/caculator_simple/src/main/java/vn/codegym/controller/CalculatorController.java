package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;

@Controller
public class CalculatorController {

    @GetMapping("/index")
    public String homepage(){
        return "/index";
    }


    @PostMapping("/index")
    public String calculate(Model model, @RequestParam String leftNumber, @RequestParam String rightNumber, @RequestParam String operator) {
        Integer result = null;
        String message = null;
        Integer numberOne = 0;
                try{
                    numberOne = Integer.parseInt(leftNumber);
                }catch (NumberFormatException e){
                    message = "Không thể nhập chữ";
                }


        Integer numberTwo = 0;
                try{
                    numberTwo =   Integer.parseInt(rightNumber);

                }catch (NumberFormatException e){
                    message = "Không thể nhập chữ";
                }
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
                if(numberTwo == 0){
                    if(numberOne < 0){
                        message = "Phương thức chia cho 0 kết quả trả về là Âm vô cùng";
                    }else if(numberOne > 0){
                        message = "Phương thức chia cho 0 kết quả trả về là Dương vô cùng";
                    }else{
                        result = 0;
                    }
                }else{
                    result = numberOne / numberTwo;
                }
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("operator",operator);
        model.addAttribute("message",message);
        return "/index";
    }
}
