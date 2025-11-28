package day01;

public class Ex02T {
    public static void main(String[] args) {
        // 변수의 선언과 초기화
        int x = 10;
        int y = 3;

        // 출력
        System.out.printf("x = %d, y = %d", x, y);
        System.out.printf("x + y = %d\n", x + y);
        System.out.printf("x - y = %d\n", x - y);
        System.out.printf("x * y = %d\n", x * y);

        /*
        //  System.out.printf("x / y = %.2f\n" , x / y);
        //  System.out.printf("x / y = %.2f\n" , 10 / 3);
        //  System.out.printf("x / y = %.2f\n" , 3);    // IllegalFormatConversionExcept
        */

        System.out.printf("x / y = %.2f\n" , (double)x / y);
        //  → System.out.printf("x / y = %.2f\n" , (double)10 / 3);
        //  → System.out.printf("x / y = %.2f\n" , 10.0 / 3.);
        //  → System.out.printf("x / y = %.2f\n" , 10.0 / 3.0);
        //  → System.out.printf("x / y = %.2f\n" ,  3.333333 );

        System.out.printf("x %% y = %d\n", x % y);
    }
}
