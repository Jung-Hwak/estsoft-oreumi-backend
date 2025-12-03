package day04;

import java.util.Scanner;

public class Ex13T {
    public static void main(String[] args) {
        // 변수 선언
        final int LENGTH = 20;
        int num;
        int decimal;
        int digits;
        int[] binary = new int[LENGTH];

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 무한 반복으로 사용자가 0을 입력할 때까지 반복문을 수행
        while (true) {
            // 사용자 입력
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();

            // 사용자가 0을 입력하면 반복문을 종료
            if (num == 0) break;

            // 래퍼 클래스인 Integer 클래스의 toBinaryString 메서드로
            // int 자료형 값을 2진수 형태의 문자열로 변환해서 출력
            System.out.printf("Binary number for decimal %d = %s\n\n",
                    num, Integer.toBinaryString(num));

        }

        // 종료 메시지 출력
        System.out.println("Good bye!");

        // 입력 스트림(input stream) 닫기
        in.close();
    }
}
