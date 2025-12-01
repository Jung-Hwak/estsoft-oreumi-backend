package JavaDemo;

public class Demo3T {
    public static void main(String[] args) {
        // 변수 선언
        final int PRINCIPAL = 50000;
        final double CS_INT_RATE = 0.05;
        final double YH_INT_RATE = 0.03;

        int cs_balance = PRINCIPAL;
        int yh_balance = PRINCIPAL;
        int year = 0;

        // do-while 구문으로 영희의 잔고가 철수의 잔고보다 작거나 같은 동안 반복문을 수행
        do {
            // 1년이 지났다!
            year++;

            // (철수의 잔고) = (철수의 이전 잔고) + (올해의 이자)
            // → (철수의 잔고) += (철수의 원금) * (철수의 이율)
            cs_balance += (int)(PRINCIPAL * CS_INT_RATE);

            // (영희의 잔고) = (영희의 이전 잔고) + (올해의 이자)
            // → (영희의 잔고) += ((영희의 원금) + (이전 이자의 합계)) * (영희의 이율)
            // → (영희의 잔고) += (영희의 이전 잔고) * (영희의 이율)
            yh_balance += (int)(yh_balance * YH_INT_RATE);
        } while (yh_balance <= cs_balance);

        // 출력
        System.out.printf("after %d years, cs = %d, yh = %d\n", year, cs_balance, yh_balance);
    }
}
