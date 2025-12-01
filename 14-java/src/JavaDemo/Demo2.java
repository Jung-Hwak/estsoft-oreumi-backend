package JavaDemo;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        num = in.nextInt();

        int one = (num / 1)   % 10;
        int ten = (num / 10)  % 10;
        int hund = (num / 100) % 10;
        int thous = (num / 1000) % 10;
        int tenthous = (num / 10000) % 10;
        in.close();

        System.out.println("1's digit = " + one);
        System.out.println("10's digit = " + ten);
        System.out.println("100's digit = " + hund);
        System.out.println("1000's digit = " + thous);
        System.out.println("10000's digit = " + tenthous);

    }
}
