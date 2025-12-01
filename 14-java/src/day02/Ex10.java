package day02;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        int n1;
        System.out.println("Enter a positive integer: ");

        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        System.out.println();

        in.close();
        for (int i = n1; i >= n1; i--) {
            System.out.println(i);
        }
    }
}
