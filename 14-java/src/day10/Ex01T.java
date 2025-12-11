package day10;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex01T {
    public static void main(String[] args) {
        // 변수 선언
        int episode;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the episode number to check: ");
        episode = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 현재 시각을 ns 단위로 확인
        long startTime = System.nanoTime();

        // solution 메서드로 "종말의 숫자"를 구해 출력
        System.out.printf("The number included in the %dth episode title = %d\n",
                episode, solution(episode));

        // 현재 시각을 ns 단위로 확인해서 solution 메서드의 실행 시간을 출력
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);

        System.out.println();

        // 현재 시각을 ns 단위로 확인
        startTime = System.nanoTime();

        // solution 메서드로 "종말의 숫자"를 구해 출력
        System.out.printf("The number included in the %dth episode title = %d\n",
                episode, solution2(episode));

        // 현재 시각을 ns 단위로 확인해서 solution 메서드의 실행 시간을 출력
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);
    }

    /**
     * N번째 "종말의 숫자"를 구하는 메서드
     *
     * @param n 구하고자 하는 "종말의 숫자"의 순서
     * @return N번째 "종말의 숫자"
     */
    static int solution(int n) {
        // 매개 변수에 전달된 인자가 0보다 작거나 같으면 IllegalArgumentException 예외를 발생
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero.");
        }

        // 변수 선언
        int count = 0;          // "종말의 숫자"의 개수
        int num = 665;          // "종말의 숫자"를 찾기 위한 변수

        // do-while 구문으로 "666"이 들어간 숫자를 탐색
        do {
            // 변수 num을 증가
            num++;

            // 변수 num을 문자열로 변환해서 "666"을 포함하는지 검사
            if (Integer.toString(num).contains("666")) {
                count++;
            }

            // 찾은 "종말의 숫자"의 개수가 매개 변수 n과 같으면 반복문을 종료
        } while (count != n);

        // 찾은 "종말의 숫자"를 반환
        return num;
    }

    static int solution2(int n) {
        // 매개 변수에 전달된 인자가 0보다 작거나 같으면 IllegalArgumentException 예외를 발생
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero.");
        }

        // 스트림으로 N번째 "종말의 숫자"를 탐색
        return IntStream.iterate(666, i -> i + 1)
                .filter(num -> Integer.toString(num).contains("666"))
                .skip(n - 1)
                .findFirst()
                .orElse(0);
    }

    /*
     * TODO: 해결하지 못했다. 생각을 좀 더 해봐야할 것 같다.
     */
    static int solution3(int n) {
        // 매개 변수에 전달된 인자가 0보다 작거나 같으면 IllegalArgumentException 예외를 발생
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero.");
        }

        // 변수 선언
        int count = 0;                  // "종말의 숫자"의 개수
        final String strBase = "666";   // "종말의 숫자"를 찾을 기본 문자열
        String strNum = "666";          // "종말의 숫자"를 찾기 위한 변수
        int i = 0;

        // do-while 구문으로 "666"이 들어간 숫자를 탐색
        do {
            // "1666", "2666", "3666", "4666", "5666", "6660", "6661", ...
            // "7666", "8666", "9666",
            // "10666", "11666", "12666", "13666", "14666", "15666",
            // i = 16, strNum = "16660", "16661", "16662", ...
            // i = 106, strNum = "106660", "106661", "106662", ...

            // 변수 i가 6이 아니면, 변수 i를 "666"의 앞에 붙인다.
            // if (i != 6) {

            // 변수 i의 1의 자리 숫자가 6이 아니면,변수 i를 "666"의 앞에 붙인다.
            if (i % 10 != 6) {
                strNum = i + strBase;
                count++;

                // System.out.printf("%3d. %s\n", count, strNum);
            } else {
                // 변수 i가 한 자리 숫자이면 뒤에 한 자리 정수가 붙는다.
                // 변수 i가 두 자리 숫자이면 뒤에 한 자리 정수가 붙는다.
                // 변수 i가 세 자리 숫자이면 뒤에 두 자리 정수가 붙는다.
                int tmp = i / 10;
                int suffix = tmp == 0 ? 10 : tmp;

                // 변수 i가 6이면, 뒤에 0, 1, 2, ..., 9를 붙인다.
                // 변수 i의 1의 자리 숫자가 6이면, 변수 i를 10으로 나눈 정수 몫을 붙인다.
                // 이때, 찾은 "종말의 숫자"의 개수가 매개 변수 n을 넘어서면 반복문을 빠져 나가야 한다.
                // for (int j = 0; j < 10 && count < n; j++) {
                for (int j = 0; j < suffix && count < n; j++) {
                    // strNum = strBase + j;
                    strNum = tmp + strBase + j;
                    count++;

                    // System.out.printf("%3d. %s\n", count, strNum);
                }
            }

            // 인덱스 변수 i를 증가
            i++;

            // 찾은 "종말의 숫자"의 개수가 매개 변수 n과 같으면 반복문을 종료
        } while (count < n);

        // 찾은 "종말의 숫자"를 반환
        return Integer.parseInt(strNum);
    }
}