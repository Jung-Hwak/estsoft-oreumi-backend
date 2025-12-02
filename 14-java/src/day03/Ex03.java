package day03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        int num;
        int n1;
        int n2;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number of rows: ");
        num = in.nextInt();
        System.out.println();
        in.close();

        for (int i = 1; i <= num; i++) {
            n1 = num - i;
            n2 = i;
            for (int j = 1; j <= n1; j++) System.out.print("");
            for (int j = 1; j <= n2; j++) System.out.print("* ");

            System.out.println();
        }
        System.out.printf("Enter a number of rows: %d\n", num);
    }
}
