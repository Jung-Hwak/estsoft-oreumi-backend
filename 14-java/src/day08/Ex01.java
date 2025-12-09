package day08;

import java.util.Random;
import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int length = 6;
        int maxNum = 45;
        int[] numbers = new int[length];

        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int num = rand.nextInt(maxNum) + 1;
            if (inArray(numbers, num)) {
            i--;
            } else {
            numbers[i] = num;
            }
            Arrays.sort(numbers);

            }
            System.out.println("numbers = " + Arrays.toString(numbers));
            System.out.println();

        System.out.print("numbers =");

        for (int item : numbers) {
            System.out.print(" " + item);
        }
    }
    public static boolean inArray(int[] array, int value) {

        for (int item : array) {
            if (item == value) return true;
        }

        return false;
    }
}
