package day09;

import java.util.Scanner;

public class Ex03T {
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

        // 이전에 구한 피보나치 수를 저장할 배열
        long[] cache = new long[num + 1];

        // fibonacci 함수로 변수 num에 해당하는 피보나치 수를 구해 출력
        System.out.printf("%dth Fibonacci number = %d\n", num, fibonacci(num, cache));

    }

    /**
     * n번째 fibonacci 수를 구하는 재귀 메서드
     *
     * @param n 구하고자 하는 피보 나치 수의 순서
     * @param cache 이전에 구한 피보나치를 저장할 배열
     * @return n번째 피보나치 수
     */
    public static long fibonacci(int n, long[] cache) {
        // 종료 조건에 해당하면 피보나치 수를 반환
        if (n <= 1) return n;

        // 이전에 구해서 저장해놓은 피보나치 수가 있으면, 그 값을 반환
        if (cache[n] != 0) return cache[n];

        // 위 조건에 해당하지 않으면, n번째 피보나치 수를 구해 배열에 저장
        cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);

        // n번째 피보나치 수를 반환
        return cache[n];
    }
}
