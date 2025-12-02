package day03;

import java.util.Scanner;

public class Ex04T {
    public static void main(String[] args) {
        // 변수 선언
        int rows;
        int spaces;
        int stars;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter the number of rows: ");
        rows = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 중첩 반복문으로 2차원 구조를 표현
        for (int i = 1; i <= rows; i++){
            // 각 행에 출력한 빈칸의 개수와 별의 개수
            spaces = rows - i;
            stars = i;

            // 빈칸을 출력
            for (int j = 1; j <= spaces; j++) System.out.print("");

            // 별을 출력
            for (int j = 1; j <= stars; j++) System.out.print("*");
            
            // 각 행의 끝에서 줄 바꿈
            System.out.println();
        }
    }
}
