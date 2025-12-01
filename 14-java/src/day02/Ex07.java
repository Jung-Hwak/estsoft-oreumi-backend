package day02;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        int n1, n2;
        System.out.println("Enter two integers: ");
        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        n2 = in.nextInt();
        in.close();

        if (n2 % n1 == 0){
            System.out.printf("%d is a multiple of %d\n", n1, n2);
        } else if (n1 % n2 == 0){
            System.out.printf("%d is a factor of %d\n", n1, n2);
        } else  {
            System.out.printf("%d is neither a factor of %d nor a multiple.", n1, n2);
        }
    }
}
