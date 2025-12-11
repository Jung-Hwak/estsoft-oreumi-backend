package day10;

import java.util.Scanner;
import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cards = new int[5];
        final int TARGET_LIMIT = 21;

        System.out.println("Enter 5 numbers between 1 and 12: ");

        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.print((i + 1) + "Enter the number (1-12): ");
                if (in.hasNextInt()) {
                    int input = in.nextInt();
                    if (input >= 1 && input <= 12) {
                        cards[i] = input;
                        break;
                    } else {
                        System.out.println("Invalid range. Please enter a number between 1 and 12.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    in.next();
                }
            }
        }
        in.close();

        System.out.println("\nCard entered: " + Arrays.toString(cards));

        int maxSum = findMaxSum(cards, TARGET_LIMIT);

        if (maxSum == 0) {
            System.out.println("I can't find a combination of 3 numbers that satisfy the condition (the sum is 21 or less).");
        } else {
            System.out.println("Maximum sum of three numbers not exceeding 21:" + maxSum);
        }
    }

    public static int findMaxSum(int[] cards, int targetLimit) {
        int max_sum = 0;
        int n = cards.length; // 5
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int current_sum = cards[i] + cards[j] + cards[k];

                    if (current_sum < targetLimit) {
                        if (current_sum > max_sum) {
                            max_sum = current_sum;
                        }
                    }
                }
            }
        }

        return max_sum;
    }
}