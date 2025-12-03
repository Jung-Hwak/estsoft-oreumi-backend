package day04;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        final int LENGTH = 30;
        int[] numbers = new int[LENGTH];
        double average = 0;
        int sum = 0;
        int n1 = 0;
        int per = 0;

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < LENGTH; i++) {
            System.out.println("Enter an integer: ");
            numbers[i] = in.nextInt();
            if (numbers[i] == 0) break;
        }
        in.close();

        average = (double) sum / n1;

        for (int item : numbers) {
            sum += item;
            average += item;
        }
        for (int i = 0; i < n1; i++ ) {
            if ( numbers[i] > average) per++;
        }
        System.out.println();
        System.out.println("average = " + average);
        System.out.printf("percentage of number above the average = %g%%\n",(double)per / n1 * 100 );
    }

}
