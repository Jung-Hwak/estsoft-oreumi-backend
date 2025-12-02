package day03;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.xml.transform.Source;
import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        int n;
        int sum = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            n = in.nextInt();
        if (n == 0) break;
        sum += n;

        }
        in.close();
        // 출력
        System.out.println();
        System.out.println("sum =  " + sum);
    }
}
