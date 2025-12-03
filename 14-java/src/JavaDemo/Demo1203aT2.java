package JavaDemo;

public class Demo1203aT2 {
    public static void main(String[] args) {
        // 2차원 배열 생성
        final int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 69, 77, 82 },
                { 91, 84, 62, 76 }
        };

        // 변수 선언
        int sum = 0;
        double average;
        final String[] ordinals = { "1st", "2nd", "3rd", "4th" };

        // 중첩 반복문으로 2차원 배열 scores의 각 열의 합계와 평균을 구해 출력
        // → 바깥쪽 반복문으로 열(columns)을 표현하고, 안쪽 반복문으로 행(rows)을 표현
        for (int i = 0; i < scores[0].length; i++) {
            // 합계를 저장할 변수를 초기화
            sum = 0;

            // for 구문으로 2차원 배열 scores의 각 열의 합계를 계산
            for (int j = 0; j < scores.length; j++)
                sum += scores[j][i];

            // 평균 계산
            average = (double)sum / scores.length;

            // 출력
            System.out.printf("%s column: sum = %d, average = %.2f\n",
                    ordinals[i], sum, average);
        }
    }
}
