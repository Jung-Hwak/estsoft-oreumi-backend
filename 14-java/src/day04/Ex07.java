package day04;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        final int limit = 19;
        final int LENGTH = 10;
        int num;
        int[] remainders = new int[limit];
        int count = 0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < LENGTH; i++) {
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();
            num %= limit;
            remainders[num]++;
        }
        in.close();
        for (int i = 0; i < limit; i++) {
            if (remainders[i] != 0) count++;
        }
        System.out.println();
        System.out.printf("number of different remainders = %d\n", count);

    }
}
