package day05;

import java.util.Scanner;

public class Ex03T {
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
        // 변수 num의 약수를 구해 출력
        System.out.printf("Divisors of %d", num);

        // for 구문으로 1에서부터 변수 num까지의 자연수가 변수 num의 약수인지 확인
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf("%d ", i);
            }
        }
        // 변수 num의 약수를 모두 출력하고 나서 줄 바꿈
        System.out.println();
         */

        // printDivisors 메서드로 사용자가 입력한 자연수의 약수를 구해 출력
        printDivisors(num);
    }

    public static void printDivisors(int num){
        // 매개 변수 num의 약수를 구해 출력
        System.out.printf("Divisors of %d", num);

        // for 구문으로 1에서부터 변수 num까지의 자연수가 변수 num의 약수인지 확인
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf("%d ", i);
            }
        }
        // 변수 num의 약수를 모두 출력하고 나서 줄 바꿈
        System.out.println();
    }
}
