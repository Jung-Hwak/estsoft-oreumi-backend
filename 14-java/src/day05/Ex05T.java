package day05;

import java.util.Scanner;

public class Ex05T {
    /**
     * 두 정수의 평균을 구하는 메서드
     *
     * @param n1 평균을 구하고자 하는 정수
     * @param n2 평균을 구하고자 하는 정수
     * @return 두 정수의 평균
     */
    public static double getAverage(int n1, int n2) {
        return (double)(n1 + n2) / 2;
    }
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter two integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // getAverage 함수로 변수 n1과 n2의 평균을 구해 출력
        System.out.printf("The average of %d and %d = %.1f\n",
                n1, n2, getAverage(n1, n2));
    }
}
