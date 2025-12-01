package day02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 프롬프트 메시지 출력
        System.out.println("Enter a string: ");

        // Scanner 클래스의 nextLine 메서드로 표준 입력에서 문자열(string)을 읽어온다.
        String str = in.nextLine();

        // 출력
        System.out.printf("str = \"%s\"", str);

//        ---------------------------------------------------------------------
        // 프롬프트 메시지 출력
        System.out.println("Enter a character: ");

        /*
        // Scanner 클래스의 nextLine 메서드로 표준 입력에서 문자열(string)을 읽어온다.
        str = in.nextLine();

        // 출력
        System.out.printf("str = \"%s\"\n\n", str);

        // String 클래스와 chara; charAt 메서드로 문자열에서 첫 번째 문자를 읽어온다.
        char ch = str.charAt(0);
        */


        // Scanner 클래스의 nextLine 입력 스트림 말로 표준 입력에서 문자열(string)을 읽어와
        // String 클래스의 charAt 메서드로 문자열에서 첫 번째 문자를 읽어온다.
        in.close();
    }
}
