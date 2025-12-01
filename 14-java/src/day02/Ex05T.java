package day02;

import java.util.Scanner;

public class Ex05T {
    public static void main(String[] args) {
        // 변수 선언
        int num;

        // Scanner 클래스 인스턴스 생성
        Scanner in = new Scanner(System.in);
        
        // 사용자 입력
        System.out.print("Enter an integer: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // if 구문으로 변수 num이 20보다 크고 40보다 작은지 확인
        if (num > 20 && num < 40)
            System.out.println("Dream comes true!");
    }
}
