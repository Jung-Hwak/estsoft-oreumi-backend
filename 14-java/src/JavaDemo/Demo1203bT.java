package JavaDemo;

import java.util.Scanner;

public class Demo1203bT {
    public static void main(String[] args) {
        // 변수 선언
        final int LENGTH = 20;
        int num;
        int decimal;
        int digits;
        int[] binary = new int[LENGTH];

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 무한 반복으로 사용자가 0을 입력할 때까지 반복문을 수행
        while (true) {
            // 사용자 입력
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();

            // 사용자가 0을 입력하면 반복문을 종료
            if (num == 0) break;

            // 사용자가 입력한 10진수의 유효성 검사
            if (num < 1 || num > 1048575) {
                System.out.println("ERROR: the entered value is out of range.\n");
                continue;
            }

            // 변수 decimal에 변수 num을 복사
            decimal = num;

            // for 구문으로 변수 decimal의 2진수를 계산
            // → 아래 for 구문의 인덱스 변수 digits는 2진수 숫자의 자릿수를 의미한다.
            for (digits = 0; decimal != 0; digits++) {
                // 변수 decimal을 2로 나누고 남은 나머지를 배열 binary의 원소에 대입
                binary[digits] = decimal % 2;

                // 변수 decimal을 2로 나눈 정수 몫을 변수 decimal에 대입
                decimal /= 2;
            }

            // 출력
            System.out.printf("Binary number for decimal %d = ", num);
            
            // for 구문으로 배열 binary에 저장되어 있는 2진수를 출력
            for (int i = digits - 1; i >= 0; i--)
                System.out.print(binary[i]);
            
            // 2진수를 출력하고 나서 줄 바꿈
            System.out.println("\n");
            
        }

        // 종료 메시지 출력
        System.out.println("Good bye!");

        // 입력 스트림(input stream) 닫기
        in.close();
    }
}
