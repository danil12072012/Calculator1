package pro.sky.calculator2.service.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator2.service.exception.DivByZeroException;

@Service
public class CalculatorServise {
    public int plus(int a, int b) {

        return a + b;
    }

    public int minus(int a, int b) {

        return a - b;
    }

    public int multiply(int a, int b) {

        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new DivByZeroException();
        }
        return a / (double) b;
    }
}