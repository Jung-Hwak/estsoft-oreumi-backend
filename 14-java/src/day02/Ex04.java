package day02;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the two positive integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        in.close();

        int quotient;
        int remainder;
        quotient = n1/n2;
        remainder = n1%n2;

        System.out.println("The quotient of the circle is " + quotient);
        System.out.println("The remainder of the circle is " + remainder);
    }
}
