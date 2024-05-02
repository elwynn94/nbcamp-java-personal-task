package calculator;

import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는
// 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//    - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다.
//    (매개변수로 해당 오류 내용을 전달합니다.)

public class Calculator {
    private final Queue<Integer> results;
    private final Queue<Double> circleResults;

    // 컴파일러가 기본 생성자를 만들어 줌. 단, 오버로딩된 생성자가 있으면 기본 생성자를 컴파일러가 만들어주지 않음. 다만 기본 생성자를 사용하지 않기
    // 때문에 없어도 됨!
    // public Calculator() {}

    public Calculator(Queue<Integer> results, Queue<Double> circleResults) {
        this.results = results;
        this.circleResults = circleResults;
    }

    // 반올림할 자릿수를 지정하여 값을 반올림하는 메서드, 함수 (ChatGPT)
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        // DecimalFormat을 사용하여 소수점 자릿수를 설정하고 반올림 모드를 설정합니다.
        DecimalFormat df = new DecimalFormat("#." + "0".repeat(places));
        df.setRoundingMode(RoundingMode.HALF_UP); // 반올림 모드 설정

        // 반올림된 값을 문자열로 변환하고 다시 double로 파싱하여 반환합니다.
        return Double.parseDouble(df.format(value));
    }

    // radius : 원의 반지름
    // return : 원의 넓이
    // 인스턴스 변수에 의존하지 않고 오로지 입력 값(radius)에만 의존하는 메서드이므로 static 을 사용해주는 것이 좋아보인다.
    public static double calculateCircleArea(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        return round(area, 2);
    }

    public Queue<Double> getCircleResults() {
        return circleResults;
    }

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

    public void removeResult(int index) { // Delete Method
        this.results.remove(index);
    }

    public void inquiryResults() {
        System.out.println("연산 결과 : " + results);
    }

    public void inquiryCircleResults() {
        System.out.println(circleResults + "cm^2");
    }
}
