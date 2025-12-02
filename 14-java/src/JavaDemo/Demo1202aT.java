package JavaDemo;

import java.util.Scanner;

public class Demo1202aT {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        boolean isPrime = true;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter a positive integer greater than1: ");
        num = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // for 구문으로 2부터 (num - 1)까지의 자연수들 중에서 변수 num의 약수가 있는지 확인
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;

                // 변수 num이 소수가 아니라는 것을 확인했으므로 반복문을 종료
                break;
            }
        }

        // 출력
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

        // ---------------------------------------------------------------------
        // 상태 변수 초기화
        isPrime = true;

        // Math 클래스의 sqrt 메서드로 변수 num의 제곱근(square root)을 구함
        double sqrt_num = Math.sqrt(num);

        // for 구문으로 2부터 변수 num의 제곱근까지의 자연수들 중에서 변수 num의 약수가 있는지 확인
        for (int i = 2; i <= sqrt_num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        // 출력
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
