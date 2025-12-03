package day04;

public class Ex12T {
    public static void main(String[] args) {
        // 2차원 배열을 생성
        int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 59, 77, 82 },
                { 91, 84, 62, 76 }
        };

        // 변수 선언
        int sum = 0;
        double average;

        // 각 행의 서수(ordinal)를 저장한 배열
        final String[] ordinals = { "1st", "2st", "3st" };

        // 중첩 반복문으로 2차원 배열 scores의 각 행의 합계와 평균을 구해 출력
        for (int i = 0; i < scores.length; i++) {
            // 합계를 저장할 변수를 초기화
            sum = 0;

            // for 구문으로 2차원 배열 scores의 각 행의 합계를 계산
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }

            // 평균 계산
            average = (double)sum / scores.length;

            // 출력
            System.out.printf("%s column: sum = %d, average = %.2f\n",
                    ordinals[i], sum, average);
        }


    }
}
