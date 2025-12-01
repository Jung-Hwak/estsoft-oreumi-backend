package day02;

import java.util.Scanner;

public class Ex08T {
    public static void main(String[] args) {
        // 변수 선언
        char ch;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter a character: ");
        ch = in.nextLine().charAt(0);
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // switch 구문으로 사용자가 입력한 문자에 따라 출력
        switch (ch) {
            case 'a':
            case 'A':
                System.out.println("Apple");
                break;
            case 'b':
            case 'B':
                System.out.println("Banana");
                break;
            case 'c':
            case 'C':
                System.out.println("Cherry");
                break;
            default:
                System.out.println("Fruit");
                break;
        }

    }
}