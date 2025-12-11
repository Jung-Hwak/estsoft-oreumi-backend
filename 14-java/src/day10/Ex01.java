package day10;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int n;
        int num = 666;
        int count = 0;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Episode number to check: ");
        n = in.nextInt();
        System.out.println();

        while (count < n) {
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            if (count == n) {
                break;
            }
            num++;
        }
        in.close();

        System.out.printf("The number included in the %dth episode title = %d\n", n, num);

    }
}
