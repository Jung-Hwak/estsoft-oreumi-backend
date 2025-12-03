package day04;

public class Ex06T {
    public static void main(String[] args) {
        // 배열 생성
        int[] numbers = {1, 3, 4, 3, 1, 3, 4, 1, 2, 3, 1, 3};

        // 배열 numbers의 원소들 중에서 1, 2, 3, 4의 개수를 저장할 배열
        int[] counts = new int[5];

        // for-each 구문으로 배열 numbers의 원소를 차례대로 확인
        for (int item : numbers) {
            /*
            if (item == 1) counts[1]++;
            else if (item == 2) counts[2]++;
            else if (item == 3) counts[3]++;
            else if (item == 4) counts[4]++;
            */

            // 위 조건문을 아래와 같이 간단하게 작성
            counts[item]++;
        }

        // 중첩 반복문으로 1, 2, 3, 4의 개수 만큼 "*"을 출력
        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");

            /*
            // 배열 counts의 원소만큼 "*"을 출력
            for (int j = 1; j < counts[i]; j++) System.out.print("*");

            // 각 행의 끝에서 줄 바꿈
            System.out.println();
            */

            // String 클래스의 repeat 메서드로 배열 counts의 원소만큼 "*"d을 출력
            System.out.println("*".repeat(counts[i]));
        }
    }
}
