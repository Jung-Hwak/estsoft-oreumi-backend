package day04;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 3, 1, 3, 4, 1, 2, 3, 1, 3};
        int[] count = new int[5];

        for (int itme : numbers) {
            count[itme]++;
        }


        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");


            for (int j = 1; j < count[i]; j++) System.out.print("*");
            System.out.println();
            System.out.print( count[i] + "*");
        }
    }
}
