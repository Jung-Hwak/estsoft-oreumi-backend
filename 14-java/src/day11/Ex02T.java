package day11;

import java.util.Arrays;

public class Ex02T {
    public static void main(String[] args) {
        final String s = "banana";

        System.out.println(Arrays.toString(solution(s)));
    }

    static int[] solution(String s) {
        // 변수 선언
        final int length = s.length();
        final int[] answer = new int[length];

        // 배열 answer의 모든 원소를 -1로 초기화
        Arrays.fill(answer, -1);

        // for 구문으로 문자열 s의 각 문자가 이전에 나온 같은 문자와 몇 칸 떨어졌는지 확인
        for (int i = 1; i < length; i++) {
            // 문자열 s의 이전에 나온 문자들 중에서 i번째 문자와 같은 문자가 있는지 확인
            for (int j = i - 1;  j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 문자열 s에서 i번째 문자와 j번째 문자가 같으면
                    // i와 j의 차이를 배열 answer의 i번째 원소에 대입
                    answer[i] = i - j;

                    // 문자열 s에서 i번째 문자와 가장 가까운 같은 문자를 확인했으니
                    // 반복문을 종료
                    break;
                }
            }
        }

        // 문자열 s의 각 문자가 이전에 나온 같은 문자와 몇 칸 떨어졌는지에 대한
        // 정보를 저장하고 있는 배열 answer를 반환
        return answer;
    }

    /*
     * 위 solution 메서드는 최악의 상황을 고려하면 시간 복잡도가 O(n²)이다.
     * 이 문제에서는 문자열 s의 최대 길이가 10,000이므로 충분히 통과할 수 있지만,
     * 문자열 s에서 각 영문자가 몇 번째 위치에 나왔는지 그 정보를 배열에 저장하면
     * 효율성을 더 개선할 수 있다.
     */
    static int[] solution2(String s) {
        // 변수 선언
        final int length = s.length();
        final int[] answer = new int[length];

        // 이 문제에서는 문자열 s에 나올 수 있는 문자가 "영어 소문자"로 제한되어 있으므로
        // 각 문자가 나온 위치를 배열에 저장할 수 있다.
        final int[] lastIndexes = new int[26];
        // → lastIndexes[0]  = 'a'가 나온 위치 (0  == 'a' - 'a')
        //   lastIndexes[25] = 'z'가 나온 위치 (25 == 'z' - 'a')

        // 배열 lastIndexes의 원소에 접근하기 위한 인덱스
        // → (현재 위치의 문자) - 'a'
        int index;

        // 배열 lastIndexes의 모든 원소를 -1로 초기화
        Arrays.fill(lastIndexes, -1);

        // for 구문으로 첫 번째 문자에서부터 이전에 같은 문자가 있는지 확인
        for (int i = 0; i < length; i++) {
            // 배열 lastIndexes의 원소에 접근하기 위한 인덱스를 계산
            index = s.charAt(i) - 'a';

            // 배열 answer의 i번째 원소에 -1 또는 이전에 나온 같은 문자와의 간격을 대입
            answer[i] = lastIndexes[index] == -1 ? -1 : i - lastIndexes[index];

            // 문자열 s에서 현재 위치의 문자가 나온 인덱스를 배열 lastIndexes에 저장
            lastIndexes[index] = i;
        }

        // 문자열 s의 각 문자가 이전에 나온 같은 문자와 몇 칸 떨어졌는지에 대한
        // 정보를 저장하고 있는 배열 answer를 반환
        return answer;
    }
}