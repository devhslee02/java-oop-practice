package org.example.caculator;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators =
            List.of(
                    new AdditionOperator(),
                    new SubtractionOperator(),
                    new MultiplicationOperator(),
                    new DivisionOperator()
            );

    public static int caculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }

//    public static int caculate(int operand1, String operator, int operand2) {
//        return switch (operator) {
//            case "+" -> operand1 + operand2;
//            case "-" -> operand1 - operand2;
//            case "*" -> operand1 * operand2;
//            case "/" -> operand1 / operand2;
//            default -> throw new IllegalStateException("Unexpected value: " + operator);
//        };
//    }
}
