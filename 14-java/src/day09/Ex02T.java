package day09;

import java.util.Scanner;

public class Ex02T {
    public static void main(String[] args) {
        // 변수 선언
        int num;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter a positive integer greater than 1: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // fibonacci 함수로 변수 num에 해당하는 피보나치 수를 구해 출력
        System.out.printf("%dth Fibonacci number = %d\n", num, fibonacci(num));

    }

    /**
     * n번째 fibonacci 수를 구하는 재귀 메서드
     *
     * @param n 구하고자 하는 피보 나치 수의 순서
     * @return n번째 피보나치 수
     */
    public static long fibonacci(int n) {
        /*
         * fibonacci(2) = fibonacci(1) + fibonacci(0);
         * → fibonacci(1) = 1;
         * → fibonacci(0) = 0;
         * → fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2);
         */

        /*
        // 피보나치 수를 저장할 변수
        long fibo = 0;

        // if-else-if 구문으로 종료 조건을 확인하고, 종료 조건에 해당하지 않으면
        // 이전 두 피보나치 수의 더해서 피보나치 수를 계산
        if (n == 0 ) fibo = 0 ;
        else if (n == 1) fibo = 1;
        else fibo = fibonacci(n - 1) + fibonacci(n - 2);
        return fibo;
         */

        // 조건 연산자로 종료 조건을 확인하고, 종료 조건에 해당하지 않으면
        // 이전 두 피보나치 수를 더해서 피보나치 수를 출력
        return n <= 1? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
