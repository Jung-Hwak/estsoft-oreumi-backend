package day09;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer greater than 1: ");
        num = in.nextInt();
        System.out.println();

        in.close();

        System.out.printf("Factorial %d = %d\n", num, factorial(num));

    }
    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}
