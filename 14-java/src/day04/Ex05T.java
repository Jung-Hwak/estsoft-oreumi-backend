package day04;

import java.util.Scanner;

public class Ex05T {
    public static void main(String[] args) {
        // 변수 선언
        final int LENGTH = 30;
        int[] numbers = new int[LENGTH];
        int sum = 0;
        int length = 0;
        double average = 0;
        int aboveAverage = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        /*
        // for 구문으로 사용자가 0을 입력할 때까지, 또는 30개를 입력할 때까지
        // 정수들을 입력받아 배열 numbers에 저장
        for (int i = 0; i < LENGTH; i++) {
            // 사용자 입력
            System.out.print("Enter an integer: ");
            numbers[i] = in.nextInt();

            // 사용자가 입력한 정수가 0이면 반복문을 종료
            if (numbers[i] == 0) break;

            // 사용자가 입력한 정수들의 개수를 증가
            length++;

            // 사용자가 입력한 정수들의 합계를 계산
            sum += numbers[i];
        }
         */
        // for 구문으로 사용자가 0을 입력할 때까지, 또는 30개를 입력할 때까지
        // 정수들을 입력받아 배열 numbers에 저장
        for (; length < LENGTH; length++) {
            // 사용자 입력
            System.out.print("Enter an integer: ");
            numbers[length] = in.nextInt();

            // 사용자가 입력한 정수가 0이면 반복문을 종료
            if (numbers[length] == 0) break;

            // 사용자가 입력한 정수들의 합계를 계산
            sum += numbers[length];
        }

        // 입력 스트림(input stream) 닫기
        in.close();

        // (평균) = (사용자가 입력한 정수들의 합계) / (사용자가 입력한 정수들의 개수)
        average = (double)sum / length;

        // for 구문으로 배열 numbers의 원소들 중에서 평균보다 더 큰 원소들의 개수를 확인
        for (int i = 0; i < length; i++ ) {
            if ( numbers[i] > average) aboveAverage++;
        }

        // 출력
        System.out.println();
        System.out.println("average = " + average);

        // 평균보다 더 큰 정수들의 백분율
        // = (평균보다 더큰 정수들의 개수) / (사용자가 입력한 정수들의 개수) * 100
        System.out.printf("percentage of number above the average = %g%%\n",(double)aboveAverage / length * 100 );
    }
}
