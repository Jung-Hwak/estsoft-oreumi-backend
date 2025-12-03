package day04;

import java.util.Scanner;

public class Ex07T {
    public static void main(String[] args) {
        // 변수 선언
        final int BASE = 19;
        final int LENGTH = 10;
        int num;
        int[] remainders = new int[BASE];
        int count = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // for 구문으로 사용자에게 자연수 10개를 입력받아 나머지를 확인
        for (int i = 0; i < LENGTH; i++) {
            // 사용자 입력
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();

            // 사용자가 입력한 자연수를 19로 나누고 남은 나머지를 계산
            num %= BASE;

            // 나머지의 개수를 증가
            remainders[num]++;
        }

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 서로 다른 나머지들의 개수를 확인
        for (int i = 0; i < BASE; i++) {
            if (remainders[i] != 0) count++;
        }

        // 출력
        System.out.println();
        System.out.printf("number of different remainders = %d\n", count);
    }
}
