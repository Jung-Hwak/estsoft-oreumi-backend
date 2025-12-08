package day07;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int Korean;
        int Math;
        int English;

        Scanner in = new Scanner(System.in);
        Korean = in.nextInt();
        Math = in.nextInt();
        English = in.nextInt();
        System.out.println();
        in.close();


        try {
            if (Korean < 0 || Math < 0 || English < 0) {
                throw new NegativeScoreException();
            }
            double Average = (double)(Korean + Math + English) / 3;
            System.out.printf("Average is %.2f", Average);
        } catch (NegativeScoreException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }

    }
}
