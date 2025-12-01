package JavaDemo;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w;
        int h;
        System.out.print("Enter hourly wage: ");
        w = in.nextInt();
        h = in.nextInt();

        int wage;
        if (h > 8) {

            wage = (8 * w) + (int)((h - 8) * w * 1.5);
        } else {
            wage = h * w;
        }

        System.out.printf("Today's wage is %d won.\n ", wage);
    }

}
