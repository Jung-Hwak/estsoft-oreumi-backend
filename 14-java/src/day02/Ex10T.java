package day02;

import java.util.Scanner;

public class Ex10T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        //사용자 입력
        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 인덱스 변수 i가 변수 num에서부터 1까지 1씩 감소하도록 하고,
        // 인덱스 변수 i를 출력
        for (int i = num; i >= num; i--) {
            System.out.println(i);
        }
    }
}
