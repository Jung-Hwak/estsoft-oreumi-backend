package day02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        int n1;
        int n2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two integer: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        in.close();

        if (n1 > n2) {
            System.out.printf("max - min = %d\n", n1 - n2);
        }  else {
            System.out.printf("min - max = %d\n", n2 - n1);
        }

    }
}
