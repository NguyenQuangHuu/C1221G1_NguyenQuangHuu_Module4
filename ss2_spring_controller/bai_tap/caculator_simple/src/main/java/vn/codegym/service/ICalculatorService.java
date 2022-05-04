package vn.codegym.service;

public interface ICalculatorService {
    Double sum(String a, String b);
    Double sub(String a, String b);
    Double multi(String a, String b);
    Double div(String a, String b) throws Exception;
}
