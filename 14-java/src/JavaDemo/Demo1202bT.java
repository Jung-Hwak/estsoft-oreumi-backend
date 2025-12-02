package JavaDemo;

import java.util.Scanner;

public class Demo1202bT {
    public static void main(String[] args) {
        // 변수 선언
        int weight;         // 철수가 배달할 설탕의 무게
        int bags = 0;       // 철수가 배달할 설탕 봉지의 개수
        int max3kg;         // 3kg 봉지로만 가져갈 경우 최대 개수
        int remain;         // 3kg 봉지를 제하고 남은 설탕의 무게

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the weight of sugar to delivered: ");
        weight = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        /*
         * 설탕 봉지를 최대한 적게 가져가려면 3kg 봉지를 최대한 적게 가져가야 한다.
         */

        // 3kg 봉지로만 배달할 경우 최대 개수를 계산
        max3kg = weight / 3;

        // for 구문으로 3kg 봉지의 개수를 0에서부터 변수 max3kg까지 1씩 증가시키면서,
        // 남은 설탕의 무게를 5kg 봉지로 맞출 수 있는지 확인
        // → 인덱스 변수 i는 3kg 봉지의 개수를 의미한다.
        for (int i = 0; i <= max3kg; i++) {
            // 3kg 봉지를 제하고 남은 설탕의 무게를 계산
            remain = weight - i * 3;

            // 3kg 봉지를 제하고 남은 설탕의 무게를 5kg 봉지로 맞출 수 있는지 확인
            if (remain % 5 == 0) {
                // 설탕 봉지의 개수 = 3kg 봉지의 개수 + 5kg 봉지의 개수
                bags = i + remain / 5;

                // 설탕 봉지를 몇 개 가져갈지 계산이 끝났으므로 반복문을 종료
                break;
            }
        }

        // 출력
        if (bags > 0) {
            System.out.printf("Cheolsu will need to bring %d bags. \n", bags);
        } else {
            System.out.printf("Cheolsu cannot take bring %d kg of sugar. \n", weight);
        }
    }
}
