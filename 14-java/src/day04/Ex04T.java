package day04;

import java.util.Scanner;

public class Ex04T {
    public static void main(String[] args) {
        // 변수 선언
        final int LENGTH = 10;
        int[] numbers = new int[LENGTH];
        int sum = 0;
        double average = 0;
        int max = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // for 구문으로 사용자에게 정수 10개를 입력받아 배열 numbers의 원소에 대입
        for (int i = 0; i < LENGTH; i++) {
            System.out.print("Enter an integer: ");
            numbers[i] = in.nextInt();
        }

        // 입력 스트림(input stream) 닫기
        in.close();

        // 배열 numbers의 원소들 중에서 최댓값을 구하기 위해, 변수 max에 배열 numbers의
        // 첫 번째 원소로 초기화 한다.
        max = numbers[0];

        // for 구문으로 배열 numbers의 원소를 차례대로 확인
        for (int item : numbers) {
            // 합계 계산
            sum += item;

            // 변수 max와 변수 item을 비교해서 배열 numbers의 원소들 중에서 최댓값을 확인
            max = Math.max(max, item);
        }

        // 평균 계산
        average = (double) sum / numbers.length;

        // 출력
        System.out.println();
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
        System.out.println("max = " + max);
    }
}
