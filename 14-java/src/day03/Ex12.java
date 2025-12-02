package day03;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        int count = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter two positive integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        for (int i = 1; i <= n1; i++) {
            if (i % n2 == 0) {
                System.out.println(i + " ");
                count++;
            }
        }

        System.out.printf("Multiples of %d and %d = %d\n", n1, n2, count);
        System.out.printf("Number of multiples of %d = %d\n", n1, n2);

        in.close();
    }
}
