package day03;

import java.util.Scanner;

public class Ex07T {
    public static void main(String[] args) {
        // 변수 선언
        int rows;
        int columns;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        rows = in.nextInt();

        System.out.print("Enter the number of columns: ");
        columns = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 바깥쪽 반복문으로 행(rows)을 표현
        for (int i = 1; i <= rows; i++) {
            // 안쪽 반복문으로 열(columns)을 표현
            for (int j = 1; j <= columns; j++)
                System.out.printf("%2d ", i + rows * (j - 1));

            // 한 행을 출력하고 줄 바꿈
            System.out.println();
        }
            System.out.println();

        // -------------------------------------------------------------
        // 출력할 정수를 변수 num으로 표현
        int num = 0;

        // 바깥쪽 반복문으로 행(rows)을 표현
        for (int i = 1; i <= rows; i++) {
            // 각 행에서 처음 출력할 정수는 인덱스 변수 i와 같다.
            num = i;

            // 안쪽 반복문으로 열(columns)을 표현
            for (int j = 1; j <= columns; j++, num += rows)
                System.out.printf("%2d ", num);

            // 한 행을 출력하고 줄 바꿈
            System.out.println();
        }
    }
}
