package JavaDemo;

import java.util.Scanner;

public class demo1201 {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;
        int fibo = 0;

        System.out.print("Enter a positive integer greater than 1: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();


        if (N == 0) fibo = 0;
        else if (N == 1) fibo = 1;
        else {
            for (int i = 2; i <= N; i++) {
                fibo = n1 + n2;
                n1 = n2;
                n2 = fibo;
            }
        }

        System.out.printf("%dth Fibonacci number = %d\n", N, fibo);
        in.close();
    }
}
