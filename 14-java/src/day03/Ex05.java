package day03;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        int rows;
        int cols;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the nuber of rows and columns: ");
        rows = in.nextInt();
        cols = in.nextInt();
        System.out.println();
        in.close();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++)
                System.out.printf("%2d ", j + cols * (i - 1));
        System.out.println();
        }
    }
}
