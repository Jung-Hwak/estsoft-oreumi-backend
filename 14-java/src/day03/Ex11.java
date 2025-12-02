package day03;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        int num;
        int count = 0;
        int sum = 0;
        int max = 0;
        int min = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            num = in.nextInt();
            if (num == 0) break;
            if (num < 0) {

            }
            if (count == 0) {
                max = num;
                min = num;
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            sum += num;
            count++;
            if (count > 0) {
                double average = sum / count;
                System.out.println("The maximum number: " + max);
                System.out.println("The minimum number: " + min);
                System.out.println("The average: " + average);
            }
        }
        in.close();
    }
}
