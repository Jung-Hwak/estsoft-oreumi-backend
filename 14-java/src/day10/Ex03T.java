package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03T {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 7, 10 };
        int divisor = 5;

        // 현재 시각을 ns 단위로 확인
        long startTime = System.nanoTime();

        int[] result = solution1(arr, divisor);

        // 현재 시각을 ns 단위로 확인해서 solution 메서드의 실행 시간을 출력
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);

        // Arrays 클래스의 toString 메서드로 배열을 문자열로 변환해서 출력
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] arr, int divisor) {
        // 스트림을 이용해 배열 arr의 원소들 중에 divisor로 나누어 떨어지는 원소들을
        // 오름차순으로 정렬한 배열을 생성
        int[] result = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .sorted()
                .toArray();

        // 스트림을 이용해 생성한 배열에 원소가 없으면 -1을 원소를 가지는 배열을 생성해서 반환
        return result.length == 0 ? new int[] { -1 } : result;
    }

    static int[] solution1(int[] arr, int divisor) {
        // 배열 arr의 원소들 중에 divisor로 나누어 떨어지는 원소들을 모아놓을 리스트
        List<Integer> list = new ArrayList<>();

        // 배열 arr의 원소들 중에 divisor로 나누어 떨어지는 원소들을 list에 저장
        for (int item : arr) {
            if (item % divisor == 0)
                list.add(item);
        }

        // list의 요소가 하나 없으면 -1을 원소로 가지는 배열을 생성해서 반환
        if (list.isEmpty())
            return new int[] { -1 };

        // list의 요소들을 오름차순으로 정렬
        Collections.sort(list);

        // list로 배열을 생성
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // 배열 result를 반환
        return result;
    }
}