package day02;

import java.util.Scanner;

public class Ex04T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter the two positive integers: ");
        int n3 = in.nextInt();
        int n4 = in.nextInt();
        System.out.println();
        
        // 입력 스트림(input stream) 닫기
        in.close();
        
        // 변수 n1을 n2로 나눈 정수 몫과 나머지를 구해 출력
        System.out.println("The quotient of the circle is " + n3 / n4);
        System.out.println("The remainder of the circle is " + n3 % n4);
    }
}
