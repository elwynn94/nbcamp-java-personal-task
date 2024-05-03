package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(
                new AddOperator(),
                new SubtractOperator(),
                new MultiplyOperator(),
                new DivideOperator(),
                new ModOperator()
        );

        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {
            System.out.println("어떤 계산을 하시겠습니까? (1: 사칙연산, 2: 원의 넓이) : ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double a = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double b = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, / |
                char c = sc.next().charAt(0); // 사용자로부터 입력받은 문자열의 첫 번째(0) 문자를 c라는 변수에 저장합니다.

                try {
                    double result = arithmeticCalculator.calculate(a, b, c);
                    System.out.println("결과 : " + result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    // 예외 후 처리
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.next();
                if (inquiry.equals("inquiry")) {
                    arithmeticCalculator.inquiryResults();
                }
            } else if (choice == 2) {
                System.out.println("원의 반지름(cm)을 입력하세요: ");
                int radius = sc.nextInt();
                double area = circleCalculator.calculateCircleArea(radius);
                System.out.println("원의 넓이는 " + area + "cm^2 입니다.");

                System.out.println("저장된 원의 넓이 전체 조회: ");
                circleCalculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String moreCalculate = sc.next();
            if (Objects.equals(moreCalculate, "exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}
