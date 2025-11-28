package day01;

public class Ex01demo {
    static void main(String[] args) {
        // ---------------------- 연습 문제 --------------------------------------------------------
        int value = 100;
        double factor = 0.98;
        char grade = 'A';

        System.out.println("value: " + value + ", Factor: " + factor + ", Grade: " + grade);
        // ----------------------- 연습 문제2 -------------------------------------------------------
        int x = 10, y = 3;

        System.out.println("x = 10, y = 3");
        System.out.println("x + y = " + x + y);
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.printf("x / y = %.2f\n" , (double) x / y);
        System.out.println("x % y = " + (x % y));
    }
}
