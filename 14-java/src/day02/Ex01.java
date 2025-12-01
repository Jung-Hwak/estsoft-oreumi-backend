package day02;

import java.util.Scanner;

public class Ex01 {
    static void main(String[] args) {
        // Scanner 클래스의 인스턴스를 생성
        Scanner in = new Scanner(System.in);

        //프롬프트 메시지(prompt message
        System.out.print("Enter an integer: ");
        
        // Scanner 클래스의 nextInt 메서드로 표준 입력에서 int 자료형의 값을 읽어옴
        int num = in.nextInt();

        // 변수 num, 즉 표준 입력에서 읽어온 값을 출력
        System.out.println("num = " + num);

        // --------------------------------------------------------------------
        //프롬프트 메시지(prompt message
        System.out.print("Enter an integer: ");

        // Scanner 클래스의 nextInt 메서드로 표준 입력에서 int 자료형의 값을 읽어옴
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        // 입력 스트림 닫기
        in.close();

        // 변수 n1과 n2, 즉 표준 입력에서 읽어온 값을 출력
        System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
    }

    public static class Ex09 {
        public static void main(String[] args) {
            int n1, n2, n3;
            Scanner in = new Scanner(System.in);
            System.out.print("Enter two integers: ");
            n1 = in.nextInt();
            n2 = in.nextInt();
            n3 = in.nextInt();
            System.out.println();
            in.close();

            n1 = n3;
            n1 = n2;
            n2 = n3;

            System.out.printf("n1 = %d n2 = %d", n1, n2);

        }
    }
}
