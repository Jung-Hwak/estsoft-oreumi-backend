package day06;

public class BankAccountT {
    // 필드(fields)
    private String owner;
    private int accountNumber;
    private int balance;

    // 메서드(methods)
    public BankAccountT(String owner, int accountNumber) {
        // 설정자로 필드에 초기화할 값을 검사
        setOwner(owner);
        setAccountNumber(accountNumber);

        balance = 0;
    }

    /*
     *  새 은행 계좌를 만들려면 소유주와 계좌 번호가 반드시 필요하므로 기본 생성자는 추가하지 않는다.
     */

    private void setOwner(String owner) {
        // TODO: 유요한 소유주의 이름인지 검사하고 나서 필드에 설정
        this.owner = owner;
    }

    private void setAccountNumber(int accountNumber) {
        // TODO: 유효한 계좌 번호인지 검사하고 나서 필드에 설정
        this.accountNumber = accountNumber;
    }

    public String getOwner() { return owner; }
    public int getAccountNumber() { return accountNumber; }
    public int getBalance() { return balance; }

    /**
     * 은행 계좌에 입금
     *
     * @prarm amount 입금할 금액
     * @return BankAccount 클래스의 인스턴스
     */

    public BankAccountT depositT(int amount) {
        // 입금하기 전에 입금할 금액을 검사
        if (amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }
        // 입금하면 입금한 금액만큼 잔고가 증가
        balance += amount;

        // 메시지 출력
        System.out.printf("You have deposited %d won.\n", amount);

        // deposit 메서드에 접근하고 있는 BankAccount 클래스의 인스턴스를 반환
        return this;
    }

    /**
     * 은행 계좌에서 출금
     *
     * @param amount 출금할 금액
     * @return BankAccount 클래스의 인스턴스
     */

    public BankAccountT withdrawT(int amount) {
        //출금하기 전에 출금할 금액을 검사
        if (amount > balance || amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }
        // 출금하면 출금한 금액만큼 잔고가 감소
        balance -= amount;

        // 메시지 출력
        System.out.printf("You have withdrawn %d won.\n", amount);

        // deposit 메서드에 접근하고 있는 BankAccount 클래스의 인스턴스를 반환
        return this;
    }

    /**
     * 은행 계좌의 잔고를 출력
     */

    public void printBalanceT() {
        System.out.printf("Balance: %d\n\n", balance);
    }

    /**
     * 은행 계좌의 정보를 출력
     */
    public void print() {
        System.out.println("Owner: " + owner);
        System.out.println("Account Number: " + accountNumber);
        printBalanceT();
    }
}
