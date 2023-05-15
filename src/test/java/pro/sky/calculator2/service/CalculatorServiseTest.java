package pro.sky.calculator2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculator2.service.exception.DivByZeroException;
import pro.sky.calculator2.service.service.CalculatorServise;

import java.security.DigestException;

public class CalculatorServiseTest {
    private final CalculatorServise calculatorServise = new CalculatorServise();

    @Test
    public void plusTest () {
        Number actual  = calculatorServise.plus(1, 2);
        Number expected = 3;

        Assertions.assertEquals(expected, actual);

         actual  = calculatorServise.plus(5, -2);
         expected = 3;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void minusTest () {
        Number actual  = calculatorServise.minus(1, 2);
        Number expected = -1;

        Assertions.assertEquals(expected, actual);

        actual  = calculatorServise.minus(5, -2);
        expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest () {
        Number actual  = calculatorServise.multiply(1, 2);
        Number expected = 2;

        Assertions.assertEquals(expected, actual);

        actual  = calculatorServise.multiply(5, -2);
        expected = -10;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideTest () {
        Number actual  = calculatorServise.divide(1, 2);
        Number expected = 0.5;

        Assertions.assertEquals(expected, actual);

        actual  = calculatorServise.divide(5, -2);
        expected = -2.5;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void divideNegativeTest () {
        Assertions.assertThrows(DivByZeroException.class, () ->calculatorServise.divide(1,0));
        Assertions.assertThrows(DivByZeroException.class, () ->calculatorServise.divide(-5,0));
    }

}
