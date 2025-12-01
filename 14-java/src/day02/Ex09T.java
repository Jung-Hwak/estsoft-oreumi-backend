package day02;

import java.util.Scanner;

public class Ex09T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter two integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 출력
        System.out.printf("n1 = %d, n2 = %d", n1, n2);

        /*
        // 변수 n1과 n2를 교환
        n1 = n2;
        n2 = n1;
        */

        // 임시 변수(temporary variable)를 이용해 변수 n1과 n2를 교환(swap)
        int tmp = n1;
        n1 = n2;
        n2 = tmp;

        // 출력
        System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
    }
}
