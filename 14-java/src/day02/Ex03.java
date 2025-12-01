package day02;

import java.util.Scanner;

public class Ex03 {
    static void main(String[] args) {
        int radius;
        double pi = (int)3.141592;
        double area;
        double circumference;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a character: ");

        radius = in.nextInt();
        System.out.println();
        in.close();

        area = pi * radius * radius;
        circumference = 2 * pi * radius;

        System.out.println("pi = " + pi);
        System.out.println("radius of the circle = " + radius);
        System.out.printf("area of the circle = %.3f\n ", area);
        System.out.printf("cricumference of the circle = %.3f\n", circumference);
    }
}
