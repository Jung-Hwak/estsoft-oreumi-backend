package day04;

import java.util.Scanner;

public class Ex02T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;
        int a, b, r;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 1. 두 자연수 중에서 큰 수를 변수 a에, 작은 수를 변수 b에 대입
        a = Math.max(n1, n2);
        b = Math.min(n1, n2);

        // 무한 반복으로 변수 r이 0이 될 때까지 반복문을 수행
        while (true) {
            // 2. 변수 a를 b로 나누고 남은 나머지를 벼수 r에 대입
            r = a % b;

            // 3. 변수 r이 0이면 변수 b가 두 자연수의 최대 공약수이다.
            if (r == 0) break;

            // 4. 다음 반복을 위해서, 변수 b를 a에, 변수 r을 b에 대입
            a = b;
            b = r;
        }

        // 출력
        System.out.printf("The greatest common divisor of %d and %d = %d\n", n1, n2, b);
    }
}
