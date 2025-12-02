package day03;

import java.util.Scanner;

public class Ex13T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        int sum = 0;
        int count = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 무한 반복으로 사용자가 0을 입력할 때까지 반복문을 수행
        while (true) {
            // 사용자 입력
            System.out.println("Enter a positive integer: ");
            num = in.nextInt();

            // 사용자가 입력한 자연수가 0이면 반복문을 종료
            if (num == 0) break;

            // 사용자가 입력한 자연수들의 평균을 구하기 위해 합계와 개수를 계산
            sum += num;
            count++;

            // 사용자가 입력한 자연수들 중에서 최댓값을 확인
            // if (num > max) max = num;
            // max = num > max ? num : max;
            max = Math.max(max, num);

            // 사용자가 입력한 자연수들 중에서 최솟값을 확인
            // if (num < min) min = num;
            // min = num < min ? num : min;
            min = Math.min(min, num);


        }

        // 입력 스트림(input stream) 닫기
        in.close();

        // 출력
        System.out.println();


        // 사용자가 자연수 하나 이상 입력한 경우에만 결과를 출력
        if (count > 0){
            System.out.println("The maximum number: " + max);
            System.out.println("The minimum number: " + min);
            System.out.println("The average: " + (double)sum / count);
        } else {
            System.out.println("ERROR: You must enter positive integers.");
        }
    }
}
