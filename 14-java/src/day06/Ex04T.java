package day06;

public class Ex04T {
    public static void main(String[] args) {
        BankAccountT myAccount = new BankAccountT("Harry Potter", 13275);

        // 은행 계좌 정보 출력
        myAccount.print();

        // 은행 계좌에 입금하고 나서 잔고를 출력
        myAccount.depositT(10000).printBalanceT();

        // 은행 계좌에서 출금하고 나서 잔고를 출력
        myAccount.withdrawT(5000).printBalanceT();

        // 은행 계좌에 입금하고 나서 잔고를 출력
        myAccount.depositT(10000).printBalanceT();

        // 은행 계좌에서 출금하고 나서 잔고를 출력
        myAccount.withdrawT(-10000).printBalanceT();

        // 은행 계좌에 입금하고 나서 잔고를 출력
        myAccount.depositT(-10000).printBalanceT();
    }
}
