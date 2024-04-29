package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] results = new int[10]; // 결과를 저장할 배열
        int count = 0; // 결과 배열의 현재 인덱스

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, / |
            char c = sc.next().charAt(0); // 사용자로부터 입력받은 문자열의 첫 번째(0) 문자를 c라는 변수에 저장합니다.

            int result = 0; // 연산 결과를 저장할 변수 result 생성

            if (c == '+' || c == '-' || c == '*' || (c == '/' && b != 0)) {
                if (c == '+') {
                    result = a + b;
                } else if (c == '-') {
                    result = a - b;
                } else if (c == '*') {
                    result = a * b;
                } else if (c == '/') {
                    result = a / b;
                }

                results[count % 10] = result; // 결과를 배열에 저장 (최대 10개까지 저장)
                count++; // index를 증가시킨다.

                System.out.println("결과 : " + result);

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