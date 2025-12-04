package day05;

import java.util.Scanner;

public class Ex05 {
    public static double getAverage(int n1, int n2) {
        return (double)(n1 + n2) / 2;
    }
    public static void main(String[] args) {
        int n1, n2;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();
        in.close();

        System.out.printf("The average of %d and %d = %.2f\n", n1, n2, getAverage(n1, n2));
    }
}
