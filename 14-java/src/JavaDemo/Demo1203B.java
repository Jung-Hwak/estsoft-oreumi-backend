package JavaDemo;

import java.util.Scanner;

public class Demo1203B {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        num = in.nextInt();

        while (true) {
            if (num > 0) {
                String binaryString = Integer.toBinaryString(num);
                System.out.printf("The binary number for decimal %d is %s ", num, binaryString);
            } else if (num == 0) break;
        }
        in.close();
    }
}
