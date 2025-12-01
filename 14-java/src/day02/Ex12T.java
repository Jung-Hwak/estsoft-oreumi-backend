package day02;

import java.util.Scanner;

public class Ex12T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        long factorial = 1;

        // Scanner 클래스 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 인덱스 변수 i가 2에서부터 변수 num 까지 1씩 증가하도록 하고,
        // 인덱스 변수 i를 변수 factorial에 누적해서 곱한다.
        for (int i = 2; i <= num; i++) {
            factorial *= i;

            // 출력
            System.out.printf("Factorial of %d = %d\n", num, factorial);
        }
    }
}
