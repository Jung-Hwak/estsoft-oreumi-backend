package day03;

import java.util.Scanner;

public class Ex09T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // do-while 구문으로 사용자가 0을 2개 입력할 때까지 반복문을 수행
        do {
            // 사용자 입력
            System.out.print("Enter two integers: ");
            n1 = in.nextInt();
            n2 = in.nextInt();

            if (n1 != 0 || n2 != 0)
                // 변수 n1과 n2의 합을 구해 출력
                System.out.printf("%d + %d = %d\n\n", n1, n2, n1 + n2);

        } while (!(n1 == 0 && n2 == 0));
        // !(n1 == 0 && n2 == 0)
        // → n1 != 0 || n2 != 0

        // 종료 메시지 출력
        System.out.println("Good bye!");

        // 입력 스트림(input stream) 닫기
        in.close();

    }
}
