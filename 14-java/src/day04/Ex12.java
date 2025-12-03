package day04;

public class Ex12 {
    public static void main(String[] args) {
        // 2차원 배열을 생성
        int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 59, 77, 82 },
                { 91, 84, 62, 76 }
        };
        int sum = 0;
        double average;
        final String[] st = { "1st", "2nd", "3rd" };
        for (int i = 0; i < scores.length; i++) {
            sum = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }
            average = (double)sum / scores.length;
            System.out.printf("%s column: sum = %d, average = %.2f\n",
                    st[i], sum, average);
        }
    }
}
