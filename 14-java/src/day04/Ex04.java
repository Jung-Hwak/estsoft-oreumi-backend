package day04;

import java.lang.classfile.attribute.SourceFileAttribute;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        int[] num = new int[10];
        double average;
        int max = 0;
        int sum = 0;

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter an integer: ");
            num[i] = in.nextInt();
        }
        System.out.println();
        in.close();

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            max = Math.max(max, num[i]);
        }
        average = (double) sum/ num.length;
        System.out.println();
        System.out.printf("average is %f\n", average);
        System.out.printf("sum = %d\n", sum);
        System.out.printf("max = %d\n", max);
    }
}
