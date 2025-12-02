package day03;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = in.nextInt();
        System.out.println();
        in.close();

        for (int i = 1; i <= num; i++) {
            for ( int j = num - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <=(2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
