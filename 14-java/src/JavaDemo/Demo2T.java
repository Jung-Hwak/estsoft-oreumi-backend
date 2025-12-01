package JavaDemo;

import java.util.Scanner;

public class Demo2T {
    public static void main(String[] args) {
        // 변수 선언
        int num;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 인덱스 변수 i가 변수 num보다 작거나 같은 동안,
        // 인덱스 변수 i를 10배씩 증가시키면서, 변수 num의 각 자리 숫자를 구한다.
        // → i = 1, 10, 100, 1000, ...;
        for (int i = 1; i <= num; i *= 10)
            System.out.printf("%d's digit = %d\n", i, num / i % 10);
    }
}
