package day11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Ex01T {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution1(int[] arr) {
        // 배열 arr에서 중복되지 않은 원소를 저장할 배열
        // → 배열 result의 크기는 배열 arr의 크기보다는 작거나 같아야 한다.
        int[] result = new int[arr.length];
        int length = 1;                         // 배열 result의 길이

        // 배열 arr의 첫 번째 원소는 중복되지 않은 값
        result[0] = arr[0];

        // for 구문으로 배열 arr의 두 번째 원소부터 이전 원소와 중복되는지 확인
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                // 배열 arr의 원소가 이전 원소와 중복되지 않으면 배열 result에 추가
                result[length++] = arr[i];
            }
        }

        // arr = [1, 1, 3, 3, 0, 1, 1]
        // result = [1, 3, 0, 1, 0, 0, 0]
        // answer = [1, 3, 0, 1]

        // java.util.Arrays 클래스의 copyOf 메서드로 배열 result의 원소들 중에서
        // 처음 length개의 원소만으로 배열을 생성해서 반환
        return Arrays.copyOf(result, length);
    }

    /*
     * Programmers에서는 solution 메서드의 반환 값 자료형을 바꿔도 된다.
     * 그러면 아래 메서드에서는 Deque<Integer> 자료형을 반환할 수 있으므로,
     * int 자료형 배열으로 변환하지 않고 Deque 인스턴스를 바로 반환할 수 있다.
     * 하지만 코딩 테스트에서는 이렇게 반환 값 자료형을 바꾸는 걸 권장하지 않는다.
     */
    static int[] solution2(int[] arr) {
        // 배열 arr의 중복되지 않은 원소를 저장할 queue
        Deque<Integer> queue = new ArrayDeque<>();

        // queue에 배열 arr의 첫 번째 원소를 추가
        // → 아래에서 peekLast 메서드를 사용하는 경우에는 Deque 인스턴스가 비어 있는지
        //   검사해야 하므로, 이 문장은 제거해도 문제되지 않는다.
        // queue.offer(arr[0]);

        // for-each 구문으로 배열 arr의 원소가 중복되지 않은지 확인해서 Deque 인스턴스에 추가
        for (int item : arr) {
            /*
             * Deque 인터페이스의 peekLast 메서드와 getLast 메서드는 뒤쪽(tail)에 있는
             * 요소를 참조한다. 단, Deque 인스턴스가 비어 있는 경우, peekLast 메서드는
             * null을 반환하고, getLast 메서드는 NoSuchElementException 예외를 발생한다.
             * 그래서 지금처럼 연이어 equals 메서드를 호출하는 경우에는, peekLast 메서드를
             * 사용하면 NullPointerException 예외가 발생할 수 있다.
             */
            // if (!queue.getLast().equals(item)) {
            if (queue.isEmpty() || !queue.peekLast().equals(item)) {
                queue.offer(item);
                // → queue.offerLast(item);
            }
        }

        // 스트림으로 Deque 인스턴스의 요소들을 int 자료형으로 변환해서 배열을 생성해 반환
        return queue.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static int[] solution(int[] arr) {
        // 스트림으로 배열 arr 원소들의 인덱스를 생성해서
        // filter 메서드로 이전 원소와 같은 원소의 인덱스를 걸러낸다.
        return IntStream.range(0, arr.length)
                .filter(i -> i == 0 || arr[i] != arr[i - 1])
                .map(i -> arr[i])
                .toArray();
    }

    /*
     * 아래 방법은 Programmers의 테스트를 통과하지 못한다.
     */
    static int[] solution4(int[] arr) {
        // 스트림의 이전 요소를 저장할 변수
        // → 이 변수는 Predicate 인스턴스에서 접근하고 있기 때문에
        //   묵시적으로 final로 선언된다.
        // int prev = -1;

        // 스트림의 이전 요소를 저장할 배열
        // → 배열을 참조하는 prev는 상수(final)이지만 배열의 원소는 상수가 아니다.
        // final int[] prev = { -1 };

        // 스트림의 이전 요소를 저장할 AtomicInteger 인스턴스
        // → 함수형 객체에서 상수(final)가 아닌 변수에 접근하도록 하는 객체
        // → 객체의 경우에는 AtomicReference<T> 클래스를 사용한다.
        AtomicInteger prev = new AtomicInteger(0);

        // 배열 arr를 스트림으로 변환해서 이전 원소와 같은 원소를 제거하고
        // 배열로 생성해서 반환
        return Arrays.stream(arr)
                .filter(n -> {
                /*
                // 함수형 객체의 본체에서는 외부에서 선언된 변수 중에서 상수(final)에만
                // 접근할 수 있다. 만약 함수형 객체의 본체에서 외부에서 선언된 변수에
                // 접근하면 상수(final)로 선언된 변수가 아니더라도 컴파일러에 의해
                // 상수(final)로 선언된다.

                // 첫 번째 요소이거나 이전 요소와 다른 경우에만 true를 반환
                boolean isDistinct = prev == -1 || prev != n;

                // 스트림의 이전 요소를 나타내는 변수 prev를 현재 요소로 갱신
                prev = n;
                */

                /*
                // 배열을 참조하는 참조 변수는 상수이지만, 배열의 원소는 상수가 아니다.
                // 그것을 이용해 아래와 같이 작성할 수는 있지만 위험하다.
                // 이 방법은 멀티 스레드 환경이나 병렬 스트림에서는 동기화가 되지 않아
                // 문제가 발생할 수 있다.

                // 첫 번째 요소이거나 이전 요소와 다른 경우에만 true를 반환
                boolean isDistinct = prev[0] == -1 || prev[0] != n;

                // 스트림의 이전 요소를 나타내는 변수 prev를 현재 요소로 갱신
                prev[0] = n;
                */

                    // 첫 번째 요소이거나 이전 요소와 다른 경우에만 true를 반환
                    boolean isDistinct = prev.get() == -1 || prev.get() != n;

                    // 스트림의 이전 요소를 나타내는 변수 prev를 현재 요소로 갱신
                    prev.set(n);

                    return isDistinct;
                })
                .toArray();
    }
}