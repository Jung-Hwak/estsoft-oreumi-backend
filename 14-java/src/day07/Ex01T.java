package day07;

import java.util.Scanner;

public class Ex01T {
    static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the dividend: ");
        n1 = in.nextInt();

        System.out.print("Enter the divisor: ");
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 예외 처리(exception handling)
        try {
            // 변수 1을 n2로 나눈 정수 몫과 나머지를 구해 출력
            System.out.println("n1 / n2 = " + n1 / n2);
            System.out.println("n1 % n2 = " + n1 % n2);
        } catch (ArithmeticException e) {
            System.out.println("ERROR: Cannot divide by zero");
        }
        // 종료 메시지 출력
        System.out.println("Good bye!");
    }
}
