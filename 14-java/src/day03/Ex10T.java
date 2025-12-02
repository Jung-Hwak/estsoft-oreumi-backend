package day03;

import java.util.Scanner;

public class Ex10T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        int sum = 0;
        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 무한 반복으로 사용자가 0을 입력할 때까지 반복문을 수행
        while (true) {
            System.out.println("Enter an positive integer: ");
            num = in.nextInt();

            // 종료 조건: 변수 num이 0이면 반복문을 종료
            if (num == 0) break;

            // 사용자가 입력한 자연수들의 합계
            sum += num;

        }
        // 입력 스트림(input stream) 닫기
        in.close();

        // 출력
        System.out.println();
        System.out.println("sum =  " + sum);
    }
}
