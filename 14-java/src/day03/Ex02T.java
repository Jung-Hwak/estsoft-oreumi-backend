package day03;

public class Ex02T {
    public static void main(String[] args) {
        // 중첩 반복문에서 바깥쪽 반복문으로 행(row)을 표현
        // → i = 1, 2, 3, ..., 9;
        for (int i = 1; i <= 9; i++) {
            // 안쪽 반복문으로 열(columns)을 표현
            // → j = 2, 3, 4, ..., 9;
            for (int j = 2; j <= 9; j++)
                // 인덱스 변수 i와 j곱을 출력
                System.out.printf("%2d ", i * j);

            // 각 행의 끝에서 줄 바꿈
            System.out.println();
        }
    }
}
