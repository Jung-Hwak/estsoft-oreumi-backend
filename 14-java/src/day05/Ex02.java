package day05;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int n1;

        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        in.close();
        printNumber(n1);
    }
    public static void  printNumber(int n1) {
        System.out.printf("My favorite number is %d.\n", n1);
    }
}
