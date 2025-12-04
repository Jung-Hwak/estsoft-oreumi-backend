package day05;

import java.util.Scanner;

public class Ex02T {
    public static void main(String[] args) {
        // 변수 선언
        int num;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter your favorite number: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        /*
        // 사용자가 입력한 정수, 즉 변수 num을 출력
        System.out.printf("Your favorite number is %d\n", num);
         */

        // printNumber 메서드로 변수 num을 출력
        printNumber(num);
        // → printNumber(3);

    }
    public static void printNumber(int num) {
        // 메서드를 호출하면 매개 변수가 선언되고, 인자로 초기화 된다.
        // int num = 3;

        System.out.printf("Your favorite number is %d.\n", num);
        // → System.out.printf("Your favorite number is %d.\n", 3);
    }
}
