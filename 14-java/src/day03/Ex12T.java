package day03;

import java.util.Scanner;

public class Ex12T {
    public static void main(String[] args) {
        // 변수 선언
        int num;
        int hours;
        int minutes;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        System.out.print("Enter '0' to exit.\n");

        // 무한 반복으로 사용자가 0을 입력할 때까지 반복문을 수행
        while (true) {
            // 사용자 입력
            System.out.print("Enter minutes: ");
            num = in.nextInt();

            // 사용자가 입력한 정수가 "0" 이면 반복문을 종료
            if (num == 0) break;

            // 사용자가 입력한 "분"으로 "시간"과 "분"을 계산
            hours = num / 60;
            minutes = num % 60;

            // 출력
            System.out.printf("%d minutes = ", num);

            /*
            // 시간(hours)을 단수와 복수로 구분해서 출력
            if (hours == 1)
                System.out.printf("%d hour", hours);
            else if (hours > 1)
                System.out.printf("%d hours", hours);

            // 분(hours)을 단수와 복수로 구분해서 출력
            if(minutes == 1)
                System.out.printf("%d minute", minutes);
            else if (minutes > 1)
                System.out.printf("%d minutes", minutes);
            */

            // 시간(hours)을 단수와 복수로 구분해서 출력
            if (hours >= 1)
                System.out.printf("%d %s", hours, hours > 1 ? "hours" : "hour");

            // 분(hours)을 단수와 복수로 구분해서 출력
            if (minutes >= 1)
                System.out.printf("%d %s", minutes, minutes > 1 ? "minutes" : "minute");

            // "시간"과 "분"을 출력하고 나서 줄바꾼
            System.out.println("\n");

        }

        // 종료 메시지 출력
        System.out.println("Good bye!");

        // 입력 스트림(input stream) 닫기
        in.close();
    }
}
