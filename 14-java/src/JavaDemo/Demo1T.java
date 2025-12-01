package JavaDemo;

import java.util.Scanner;

public class Demo1T {
    public static void main(String[] args) {
        // 변수 선언
        int hourlyWage;
        int hours;
        int todayWage;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter the hourly wage: ");
        hourlyWage = in.nextInt();

        System.out.println("Enter the hourly worked: ");
        hours = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // if-else 구문으로 근무 시간이 8시간을 초과하는지 확인
        if (hours > 8)
            // (하루 급여) = (시급) * (8시간) + (시급의 150%) + (8시간을 초과한 근무 시간)
            todayWage = hourlyWage * hours + (int)(hourlyWage * 1.5 *(hours - 8));
         else
            // (하루 급여) = (시급) * (근무 시간)
            todayWage = hourlyWage * hours;

         // 출력
        System.out.printf("Today's wage is %d won.\n", todayWage);

        // ---------------------------------------------------------------------------
        // (근무 시간에 따른)

    }
}
