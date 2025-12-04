package JavaDemo;

public class Demo1203A {
    public static void main(String[] args) {
        final int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 69, 77, 82 },
                { 91, 84, 62, 76 }
        };
        int[] sum = new int[scores[0].length];
        double average;
        final String[] ordinals = { "1st", "2nd", "3rd", "4th" };

        for (int i = 0; i < scores.length; i++)
            for (int j = 0; j < scores[i].length; j++)
                sum[j] += scores[i][j];

        for (int i = 0; i < scores[0].length; i++) {
            average = (double)sum[i] / scores.length;

            System.out.printf("%s column: sum = %d, average = %.2f\n",
                    ordinals[i], sum[i], average);
        }
    }
}
