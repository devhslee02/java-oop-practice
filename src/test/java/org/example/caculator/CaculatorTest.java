package org.example.caculator;

import net.bytebuddy.implementation.bind.annotation.Argument;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CaculatorTest {
    @DisplayName("사칙연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void caculationTest(int operand1, String operator, int operand2, int result) {
        int caculatedResult = Calculator.caculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(caculatedResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void caculationExceptionTest() {
        assertThatCode(() -> Calculator.caculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }

    @DisplayName("음수를 전달할 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void caculationExceptionTest2() {
        assertThatCode(() -> Calculator.caculate(new PositiveNumber(10), "/", new PositiveNumber(-2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }


//    @DisplayName("곱셈연산을 수행한다.")
//    @Test
//    void additionTest() {
//        int result = Calculator.caculate(1, "*", 2);
//
//        assertThat(result).isEqualTo(2);
//    }
//
//    @DisplayName("나눗셈연산을 수행한다.")
//    @Test
//    void additionTest() {
//        int result = Calculator.caculate(1, "/", 2);
//
//        assertThat(result).isEqualTo(0.5);
//    }
}
