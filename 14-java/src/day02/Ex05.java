package day02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num = in.nextInt();
        System.out.println();
        in.nextLine();

        if (20 < num && num < 40) {
            System.out.println("Enter an integer: " + num);
            System.out.println("Dream comes true!");
        }
    }
}
