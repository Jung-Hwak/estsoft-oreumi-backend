package JavaDemo;

import java.util.Scanner;
import day07.NegativeScoreException;

public class Demo1208 {
    public static void main(String[] args) {

        int korean, math, english;
        double average;
        Scanner in = new Scanner(System.in);

        korean = getScore(in, "Korean");
        math = getScore(in, "Math");
        english = getScore(in, "English");

        average = (korean + math + english) / 3.0;
        System.out.println();
        System.out.printf("Average: %.2f\n", average);
    }

    public static int getScore(Scanner in, String subject) {
        while (true) {
            try {
                System.out.print("Enter " + subject + " score: ");
                int score = in.nextInt();

                if (score < 0) {
                    throw new NegativeScoreException();
                }
                if (score > 100) {
                    throw new InvalidScoreException();
                }

                return score;

            } catch (NegativeScoreException | InvalidScoreException e) {
                System.err.println(e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.err.println("Input must be a number. Try again.");
                in.nextLine();
            }
        }
    }
}
