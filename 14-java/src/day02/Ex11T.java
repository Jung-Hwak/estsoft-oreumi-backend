package day02;

public class Ex11T {
    public static void main(String[] args) {
        // 1부터 100까지의 자연수들의 합계를 저장할 변수
        int sum = 0;

        // for 구문으로 인덱스 변수 i가 1에서부터 100까지 1씩 증가하도록 하고,
        // 변수 sum에 인덱스 변수 i를 누적해서 더한다
        // → i = 1, 2, 3, ..., 99, 100;
        for (int i = 1; i <= 100; i++) {
            sum += i;

            // 출력
            System.out.println("The sum of the integers between 1 and 100" + sum);

            // ---------------------------------------------------------------------------
            // 가우스의 덧셈 공식을 이용해 1부터 100까지의 자연수들의 합을 구해 출력
            // → 등차 수열의 합은 첫 항과 마지막 항을 더해서 항수를 곱하고 2로 나눈다
            System.out.printf("The sum of the integers between 1 and 100 = %d\n",
                    (1 + 100) * 100 / 2);
        }

    }
}
