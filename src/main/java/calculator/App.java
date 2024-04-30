package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> results = new LinkedList<>(); // results Queue 생성

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, / |
            char c = sc.next().charAt(0); // 사용자로부터 입력받은 문자열의 첫 번째(0) 문자를 c라는 변수에 저장합니다.

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
                        System.out.println("나눗셈 연산에서 분모가 0이 입력될 수 없습니다.");
                    } else {
                        result = a / b;
                    }
                }

                System.out.println("결과 : " + result);
                results.add(result); // 결과값을 results Queue에 추가


                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String remove = sc.next();
                if (remove.equals("remove")) {
                    results.remove(results.poll()); // 가장 최신 결과값을 꺼냄 (삭제)
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.next();
                if (inquiry.equals("inquiry")) {
                    for (Integer i : results) {
                        System.out.println(i);
                    }
                }

            } else {
                System.out.println("사칙연산 기호만 넣어주세요. (+, -, *, /)");
                continue;
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