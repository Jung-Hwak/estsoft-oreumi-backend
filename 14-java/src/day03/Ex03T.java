package day03;

public class Ex03T {
    public static void main(String[] args) {
        // 중첩 반복문에서 바깥쪽 반복문으로 행(row)을 표현
        for (int i = 1; i <= 9; i++) {
            // 안쪽 반복문으로 열(columns)을 표현
            for (int j = 1; j <= i; j++)
                System.out.printf("*");

            // 각 행의 끝에서 줄바꿈
            System.out.println();
        }
    }
}
