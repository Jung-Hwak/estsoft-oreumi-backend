package day04;

import java.util.Scanner;

public class Ex08T {
    public static void main(String[] args) {
        // 변수 선언
        int amount;
        int[] coinUnits = { 500, 100, 50, 10};
        final int NUM_COINS = 10;
        int num = 0;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the amount to be repaid: ");
        amount = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 사용자가 입력한 값으 유효성 검사 (validation)
        if (amount < 10 || amount > 6600 || amount % 10 != 0) {
            System.out.println("ERROR: Invalid amount");

            return;
        }

        // for-each 구문으로 500원짜리 동전에서부터 몇 개씩 거슬러 줘야 하는지 계산
        for (int unit : coinUnits) {
            // 거슬러줄 동전의 개수를 계산
            num = amount / unit;

            // 거슬러 줄 동전이 있는 경우
            if (num > 0) {
                // 거슬러 줄 동전의 최대 개수는 10개이다.
                num = Math.min(num, NUM_COINS);

                // 현재 단위의 동전을 거슬러 주고 남은 거스름돈을 계산
                amount -= num * unit;

                // 출력
                System.out.printf("%3d won coins = %d\n", unit, num);

                // 더 이상 거슬러 줄 거스름돈이 없으면 반복문을 종료
                if (amount == 0) break;
            }
        }

    }
}
