package day04;

public class Ex11T {
    static void main() {
        // 2차원 배열을 생성하고 참조 변수에 대입
        int[][] numbers = {
                {1, 2, 3, 4 },
                {5, 6, 7, 8 },
                {9, 10, 11, 12 },
        };

        // 중첩 반복문으로 2차원 배열의 모든 원소에 차례대로 접근
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("numbers[%d][%d] = %d\n", i, j, numbers[i][j]);
            }
        }

    }
}
