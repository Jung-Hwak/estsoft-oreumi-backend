package day02;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        long factorial = 1;
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();
        in.close();

        for (int i = num; i <= num; i++) {
            factorial *= i;

            System.out.printf("Factorial of %d is: %d\n", num, factorial);
        }
    }
}
