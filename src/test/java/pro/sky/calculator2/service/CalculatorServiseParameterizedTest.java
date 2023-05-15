package pro.sky.calculator2.service;


import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator2.service.exception.DivByZeroException;
import pro.sky.calculator2.service.service.CalculatorServise;

import java.util.stream.Stream;

public class CalculatorServiseParameterizedTest {

    private final CalculatorServise calculatorServise = new CalculatorServise();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-10, 2, -12)
        );
    }
    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-10, 2, -20)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(0, 2, 0)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-10, 0)
        );
    }


    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest (int a, int b,int expected ) {
        Assertions.assertThat(calculatorServise.plus(a,b)).
                isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest (int a, int b,int expected ) {
        Assertions.assertThat(calculatorServise.minus(a,b)).
                isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest (int a, int b,int expected ) {
        Assertions.assertThat(calculatorServise.multiply(a,b)).
                isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int a, int b, Number expected ) {
        Assertions.assertThat(calculatorServise.divide(a,b)).
                isEqualTo(expected.doubleValue(), (Offset<Double>) Offset.offset(0D));
    }
    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(int a, int b) {
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                        .isThrownBy(() -> calculatorServise.divide(a, b));

    }


}
