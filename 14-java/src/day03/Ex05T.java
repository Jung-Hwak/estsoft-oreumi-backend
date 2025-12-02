package day03;

import java.sql.SQLOutput;

public class Ex05T {
    public static void main(String[] args) {
        // 변수 선언
        int rows = 10;
        int spaces;
        int stars;

        // 중첩 반복문으로 2차원 구조를 표현
        for (int i = 1; i <= rows; i++) {
            // 각 행에서 출력할 빈칸의 개수와 별의 개수를 계산
            spaces = rows - i;
            stars = i * 2 - 1;

            /*
            // 변수 spaces만큼 빈칸을 출력
            for (int j = 1; j <= spaces; j++) System.out.print(" ");

            // 변수 stars만큼 별을 출력
            for (int j = 1; j <= stars; j++) System.out.print("*");
            */

            // 변수 spaces와 stars만큼 빈칸과 별을 출력
            System.out.println(" ".repeat(spaces) + "*".repeat(stars));

            // 각행의 끝에서 줄 바꿈
            System.out.println();
        }
    }
}
