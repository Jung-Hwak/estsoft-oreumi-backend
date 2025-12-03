package day04;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        int coins;
        int[] coinunits = { 500, 100, 50, 10};
        int max_coins = 10;
        int num = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the amount to be repaid: ");
        coins = in.nextInt();
        System.out.println();
        in.close();
        if (coins < 10 || coins > 6600 || coins % 10 != 0) {
            System.out.println("ERROR: Invalid amount");

            return;
        }
        for (int unit : coinunits) {
            num = coins / unit;
            if (num > 0) {
                num = Math.min(num, max_coins);
                coins -= num * unit;
                System.out.printf("%3d won coins = %d\n", unit, num);
                if (coins == 0) break;
            }
        }



    }
}
