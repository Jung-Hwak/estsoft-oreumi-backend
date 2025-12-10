package day09;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int num;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();
        in.close();

        for (int i = 0; i <= num; i++) {
            System.out.printf("fibonacci %d = %d\n", i, fibonacci(num));
        }
            System.out.printf("%dth Fibonacci number = %d\n", num, fibonacci(num));


    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
