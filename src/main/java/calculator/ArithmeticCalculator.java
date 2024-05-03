package calculator;

public class ArithmeticCalculator extends Calculator {

    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;
    private final ModOperator modOperator;

    public ArithmeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator,
                                DivideOperator divideOperator, ModOperator modOperator) {
        super();
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = new ModOperator();
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
        double result = 0;

        if (c == '+') {
            result = addOperator.operate(a, b);
        } else if (c == '-') {
            result = subtractOperator.operate(a, b);
        } else if (c == '*') {
            result = multiplyOperator.operate(a, b);
        } else if (c == '/') {
            result = divideOperator.operate(a, b);
        } else if (c == '%') {
            result = modOperator.operate(a, b);
        } else {
            throw new UnsupportedOperationException("사칙연산 기호만 넣어주세요. (+, -, *, /)");
        }

        calculationResults.add(result);

        return result;
    }
}
