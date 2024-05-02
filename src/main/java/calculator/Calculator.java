package calculator;

import java.util.*;

// 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는
// 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//    - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다.
//    (매개변수로 해당 오류 내용을 전달합니다.)

public class Calculator {
    private final Queue<Integer> results = new LinkedList<>();



    public int calculate(int a, int b, char c) {
        int result = 0; // 연산 결과를 저장할 변수 result 생성

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
                    results.add(result); // 결과값을 results Queue에 추가

                    return result;
    }

    public Queue<Integer> getResults() {
        return results;
    }

    public void removeResult(int index) { // 삭제 Method
        this.results.remove(index);
    }
}
