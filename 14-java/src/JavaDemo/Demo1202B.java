package JavaDemo;

import java.util.Scanner;

public class Demo1202B {
    public static void main(String[] args) {
        int fiveBag = 0;
        int threeBag = 0;
        int totalBags = -1;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the weight of sugar to be delivered: ");
        int weight = scan.nextInt();
        System.out.println();

        scan.close();

        fiveBag = weight / 5;

        while (fiveBag >= 0) {
            int remain = weight - (fiveBag * 5);

            if (remain % 3 == 0) {
                threeBag = remain / 3;
                totalBags = fiveBag + threeBag;
                break;
            }

            fiveBag--;
        }

        if (totalBags == -1) {
            System.out.printf("Cheolsu cannot bring %d kg of sugar.\n", weight);
        } else {
            System.out.printf("Cheolsu will need to bring %d bags.\n", totalBags);
        }
    }
}
