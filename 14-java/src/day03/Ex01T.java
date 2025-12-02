package day03;

import java.util.Scanner;

public class Ex01T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        long f0 = 0;
        long f1 = 1;
        long fibo = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter a positive integer greater than 1: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 두번째 피보나치 수부터 N번째 피보나치 수까지 차례대로 계산
        for (int i = 2; i <= num; i++) {
            // i 번째 피보나치 수를 계산
            fibo = f0 + f1;

            // 다음 반복에서 다음 피보나치 수를 구하기 위해 변수 f0와 f1을 갱신
            f0 = f1;
            f1 = fibo;
        }

        // 출력
        System.out.printf("%dth Fibonacci number = %d\n", num, fibo);
    }
}
