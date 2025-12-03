package day04;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int n1, n2;
        int a, b, r;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter two positive integers: ");
        n1 = input.nextInt();
        n2 = input.nextInt();
        System.out.println();
        input.close();

        a = Math.max(n1, n2);
        b = Math.min(n1, n2);


        while (true) {
            r = a % b;
            if (r == 0) break;
            a = b;
            b = r;
        }
        System.out.printf("The greatest common divisor of %d and %d = %d\n", n1, n2, b);
    }
}
