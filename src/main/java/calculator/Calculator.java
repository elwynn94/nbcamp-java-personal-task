package calculator;

import java.util.LinkedList;
import java.util.Queue;

// 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는
// 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//    - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다.
//    (매개변수로 해당 오류 내용을 전달합니다.)

public class Calculator {
    private Queue<Integer> results;

    public Calculator() {
        this.results = new LinkedList<>();
    }

    public int calculate(int a, int b, char c) throws InvalidOperatorException, DivisionByZeroException {
        int result = 0; // 연산 결과를 저장할 변수 result 생성

        if (c == '+' || c == '-' || c == '*' || c == '/') {
            if (c == '+') {
                result = a + b;
            } else if (c == '-') {
                result = a - b;
            } else if (c == '*') {
                result = a * b;
            } else if (c == '/') {
                if (b == 0) {
                    throw new DivisionByZeroException("나눗셈 연산에서 분모가 0이 입력되었습니다.");
                } else {
                    result = a / b;
                }

                System.out.println("결과 : " + result);
                results.add(result); // 결과값을 results Queue에 추가
            }
        } else {
            throw new InvalidOperatorException("사칙연산 기호만 넣어주세요. (+, -, *, /)");
        }
        return result;
    }

    // 예외 클래스 정의
    static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }

    static class InvalidOperatorException extends Exception {
        public InvalidOperatorException(String message) {
            super(message);
        }
    }
}
