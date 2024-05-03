package calculator;

public class DivideOperator {
    public double operate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모가 0이 입력될 수 없습니다.");
        }
        return a / b;
    }
}
