package day04;

public class Ex10 {
    public static void main(String[] args) {
        // 변수 선언
        final int NUM = 100;
        final double SQRT_NUM = Math.sqrt(NUM);
        boolean[] isPrime = new boolean[NUM + 1];

        // 2부터 NUM까지의 자연수들의 모두 소수라고 가정
        for (int i = 2; i < isPrime.length; i++)
            isPrime[i] = true;

        // 에라토스테네스의 체 알고리즘을 이용해, 2부터 NUM까지의 자연수들 중에서
        // 소수가 아닌 자연수들을 걸러낸다.
        for (int i =2; i <= SQRT_NUM; i++) {
            if (isPrime[i]) {
                // 변수 i가 소수이면, 변수 i를 제외한 i의 배수는 소수가 아니다.
                for (int j = i * i; j <= NUM; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 출력
        System.out.printf("Prime numbers between 2 nad %d:\n", NUM);

        // for 구문으로 배열 isPrimes의 원소들 중에서 true인 원소의 인덱스를 출력
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) System.out.printf("%d ", i);
        }

        // 소수를 모두 출력하고나서 줄 바꿈
        System.out.println();
    }
}
