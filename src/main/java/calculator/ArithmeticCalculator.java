package calculator;

import java.util.List;

public class ArithmeticCalculator extends Calculator {

    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;
    private final ModOperator modOperator;

    public List<Double> getResultsGreaterThanInput(double inputValue) {
        // 입력값보다 큰 결과들을 필터링하여 반환
        return getCalculationResults().stream()
                .filter(result -> result > inputValue)
                .toList();
    }

    public ArithmeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator,
                                DivideOperator divideOperator, ModOperator modOperator) {
        super();
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
    }

    @Override
    public void removeResult(int index) {
        super.removeResult(index);
    }

    @Override
    public void inquiryResults() {
        super.inquiryResults();
    }

    public double calculate(double a, double b, char c) {
        OperatorType operator = switch (c) {
            case '+' -> OperatorType.ADDITION;
            case '-' -> OperatorType.SUBTRACTION;
            case '*' -> OperatorType.MULTIPLICATION;
            case '/' -> OperatorType.DIVISION;
            case '%' -> OperatorType.MODULUS;
            default -> throw new UnsupportedOperationException("사칙연산과 나머지(%) 기호만 넣어주세요. (+, -, *, /, %)");
        };

        double result = switch (operator) {
            case ADDITION -> addOperator.operate(a, b);
            case SUBTRACTION -> subtractOperator.operate(a, b);
            case MULTIPLICATION -> multiplyOperator.operate(a, b);
            case DIVISION -> divideOperator.operate(a, b);
            case MODULUS -> modOperator.operate(a, b);
        };

        addResult(result); // 계산 결과를 추가
        return result;
    }
}
