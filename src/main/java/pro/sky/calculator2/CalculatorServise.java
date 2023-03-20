package pro.sky.calculator2;

import org.springframework.stereotype.Service;

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
        return a / (double) b;
    }
}