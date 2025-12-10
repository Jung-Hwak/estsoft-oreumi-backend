package day09;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Ex01T {
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

        // factorial 함수로 변수 num의 팩토리얼을 구해 출력
        System.out.printf("Factorial %d = %d\n", num, factorial(num));

    }

    /**
     * 자연수의 팩토리얼을 구하는 재귀 메서드
     *
     * @param n 팩토리얼을 구하고자 하는 자연수
     * @return n의 팩토리얼
     */

    public static long factorial(int n) {
        /*
        // factorial(1)은 1을 반환하고 종룡
        if (n == 1) return 1;

        // 재귀 호출로 매개 변수 n의 팩토리얼을 구해 반환
        return n * factorial(n - 1);
        */

        // 조건 연산자로 위 두 문장을 간단하게 작성
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
