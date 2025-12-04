package JavaDemo;

import java.util.Scanner;

public class Demo1203B {
    public static void main(String[] args) {
        final int LENGTH = 20;
        int num;
        int decimal;
        int digits;
        int[] binary = new int[LENGTH];

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();
            if (num == 0) break;
            if (num < 1 || num > 1048575) {
                System.out.println("ERROR: the entered value is out of range.\n");
                continue;
            }
            decimal = num;
            for (digits = 0; decimal != 0; digits++) {
                binary[digits] = decimal % 2;
                decimal /= 2;
            }
            System.out.printf("Binary number for decimal %d = ", num);
            for (int i = digits - 1; i >= 0; i--)
                System.out.print(binary[i]);
            System.out.println("\n");
        }
        System.out.println("Good bye!");
        in.close();
    }
}
