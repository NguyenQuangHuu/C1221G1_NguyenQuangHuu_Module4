package vn.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public Double sum(String a, String b) {

        return Double.valueOf(a + b);
    }

    @Override
    public Double sub(String a, String b) {
        Double numberA = Double.parseDouble(a);
        Double numberB = Double.parseDouble(b);

        return numberA - numberB;
    }

    @Override
    public Double multi(String a, String b) {
        Double numberA = Double.parseDouble(a);
        Double numberB = Double.parseDouble(b);

        return numberA * numberB;
    }

    @Override
    public Double div(String a, String b) throws Exception {
        Double result = null;
        Double numberA = Double.parseDouble(a);
        Double numberB = Double.parseDouble(b);
        if (numberB == 0) {
            if (numberA < 0) {

                    throw new Exception("Âm vô cùng");

            } else if (numberA > 0) {
                    throw new Exception("Dương vô cùng");
            }else{
                result = 0.0;
            }
        }else{
            
           result = numberA / numberB;
        }
        return result;
    }
    
}
