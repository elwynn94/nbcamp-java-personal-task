package calculator;

public class ArithmeticCalculator extends Calculator {
    public ArithmeticCalculator() {
        super();
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
            result = a + b;
        } else if (c == '-') {
            result = a - b;
        } else if (c == '*') {
            result = a * b;
        } else if (c == '/') {
            if (b == 0) {
                throw new ArithmeticException("나눗셈 연산에서 분모가 0이 입력될 수 없습니다.");
            } else {
                result = a / b;
            }
        } else {
            throw new UnsupportedOperationException("사칙연산 기호만 넣어주세요. (+, -, *, /)");
        }

        System.out.println("결과 : " + result);
        calculationResults.add(result);

        return result;
    }
}
