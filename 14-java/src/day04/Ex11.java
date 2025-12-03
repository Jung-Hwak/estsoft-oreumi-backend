package day04;

public class Ex11 {
    static void main() {
        int[][] numbers = {
                {1, 2, 3, 4 },
                {5, 6, 7, 8 },
                {9, 10, 11, 12 },
        };
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("numbers[%d][%d] = %d\n", i, j, numbers[i][j]);
            }
        }
    }
}
