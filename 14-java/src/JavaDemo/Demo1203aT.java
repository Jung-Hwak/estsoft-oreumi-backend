package JavaDemo;

public class Demo1203aT {
    public static void main(String[] args) {
        // 2차원 배열 생성
        final int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 69, 77, 82 },
                { 91, 84, 62, 76 }
        };

        // 2차원 배열에서 각 열의 합계를 저장할 배열
        int[] sumColumns = new int[scores[0].length];
        double average;

        // 각 열의 서수를 저장할 배열
        final String[] ordinals = { "1st", "2nd", "3rd", "4th" };

        // 중첩 반복문으로 2차원 배열 scores의 각 열의 합계를 계산
        for (int i = 0; i < scores.length; i++)
            for (int j = 0; j < scores[i].length; j++)
                sumColumns[j] += scores[i][j];

        // for 구문으로 2차원 배열 scores의 각 열의 평균을 구해 출력
        for (int i = 0; i < scores[0].length; i++) {
            average = (double)sumColumns[i] / scores.length;

            System.out.printf("%s column: sum = %d, average = %.2f\n",
                    ordinals[i], sumColumns[i], average);
        }
    }
}
