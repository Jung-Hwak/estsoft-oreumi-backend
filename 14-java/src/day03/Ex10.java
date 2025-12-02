package day03;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        int num;
        int hours;
        int minutes;

        Scanner in = new Scanner(System.in);
        while (true) {
        System.out.print("Enter minute: ");
        num = in.nextInt();
            if (num == 0) break;
            hours = num / 60;
            minutes = num % 60;
        System.out.printf("%d minutes  = %d hours %d minutes", minutes, hours);

        }
        in.close();
    }
}
