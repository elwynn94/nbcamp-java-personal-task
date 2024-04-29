package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, / |
            char c = sc.next().charAt(0); // 사용자로부터 입력받은 문자열의 첫 번째(0) 문자를 c라는 변수에 저장.

            if (c == '+') {
                System.out.println("결과 : " + (a + b));
            } else if (c == '-') {
                System.out.println("결과 : " + (a - b));
            } else if (c == '*') {
                System.out.println("결과 : " + (a * b));
            } else if (c == '/') {
                if (b != 0) {
                    System.out.println("결과 : " + (a / b));
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
            } else {
                System.out.println("사칙연산 기호만 넣어주세요. (+, -, *, /)");
                continue;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String more = sc.next();
            if (Objects.equals(more, "exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}