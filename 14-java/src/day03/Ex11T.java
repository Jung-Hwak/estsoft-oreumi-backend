package day03;

import java.util.Scanner;

public class Ex11T {
    public static void main(String[] args) {
        // 변수 선언
        int treeHeight;
        int riseDay;
        int slidingNight;

        int snailHeight = 0;
        int days = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the tree height: ");
        treeHeight = in.nextInt();

        System.out.print("Enter the height that rises during the day: ");
        riseDay = in.nextInt();

        System.out.print("Enter the sliding height at night: ");
        slidingNight = in.nextInt();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 달팽이가 낮 동안 올라간 높이는 밤에 미끄러지는 높이보다 커야 한다.
        if (slidingNight >= riseDay) {
            System.out.println("ERROR: The snail can never reach the top of the tree.");
            return;
        }

        // 무한 반복으로 달팽이가 나무 꼭대기에 도착할 때까지 며칠 걸리는지 확인
        while (true) {
            // 날짜 증가
            days++;

            // 달팽이가 낮 동안 올라간 높이를 계산
            snailHeight += riseDay;

            // 달팽이가 나무 꼭대기에 도착했는지 확인
            if (snailHeight >= treeHeight) break;

            // 달팽이가 밤에 미끄러지는 높이를 계산
            snailHeight -= slidingNight;
        }

        // 출력
        System.out.printf("It takes %d days for the snail to climb the tree. \n", days);
    }
}
