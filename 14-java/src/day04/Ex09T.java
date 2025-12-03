package day04;

public class Ex09T {
    public static void main(String[] args) {
        // 변수 선언
        final int NUM = 100;
        boolean isPrime = true;
        double sqrt;

        // 출력
        System.out.printf("Prime numbers between 2and $d:\n", NUM);

        // for 구문으로 2부터 NUM까지의 자연수들을 차례대로 확인
        for (int i = 2; i <= NUM; i++) {
            // 변수 i가 소수라고 가정
            isPrime = true;

            // 변수 i의 제곱근
            sqrt = Math.sqrt(i);

            // for 구문으로 2부터 변수 i의 제곱근까지의 자연수 들중에서 변수 i의 약수가 있는지 확인
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // 변수 i가 소수이면 출력
            if (isPrime) System.out.print(i + " ");
        }

        // 소수를 모두 출력하고 나서 줄 바꿈
        System.out.println();
    }
}
