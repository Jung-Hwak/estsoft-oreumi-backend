package day04;

import java.util.Scanner;

public class Ex01T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;
        int gcd = 1;
        int min;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 변수 n1과 n2 중에서 작은 수를 확인
        min = Math.min(n1, n2);

        // for 구문으로 변수 min에서부터 1까지의 자연수들 중에서 변수 n1과 n2의 공약수를 확인
        for (int i = min; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
                break;
            }
        }

        // 출력
        System.out.printf("The greatest common divisor of %d and %d = %d\n", n1, n2, gcd);
    }
}
