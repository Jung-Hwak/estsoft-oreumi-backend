package day03;

import java.util.Scanner;

public class Ex14T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;
        int count = 0;
        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 출력
        System.out.printf("Multiples of %d between 1and  %d =", n1, n2);

        /*
        // for 구문으로 1에서부터 변수 n1까지의 자연수들 중에서 변수 n2의 배수를 출력
        for (int i = 1; i <= n1; i++) {
            if (i % n2 == 0) {
                System.out.printf(" %d", i);
                count++;
            }
        }
        */
        // for 구문으로 1에서부터 변수 n1까지의 자연수들 중에서 변수 n2의 배수를 출력
        for (int i = n2; i <= n1; i+= n2, count++){
                System.out.printf(" %d", i);
        }

        System.out.println();
        System.out.printf("Number of multiples of %d = %d\n", n2, count);

    }
}
