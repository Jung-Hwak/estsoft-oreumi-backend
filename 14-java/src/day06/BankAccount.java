package day06;

public class BankAccount {
    private String owner;
    private int accountNumber;
    private int balance;

    public BankAccount(String owner, int accountNumber) {
        setOwner(owner);
        setAccountNumber(accountNumber);

        balance = 0;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    private void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() { return owner; }
    public int getAccountNumber() { return accountNumber; }
    public int getBalance() { return balance; }

    public BankAccount deposit(int amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }

        balance += amount;

        System.out.printf("You have deposited %d won.\n", amount);
        return this;
    }
    public BankAccount withdraw(int amount) {
        if (amount > balance || amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }
        balance -= amount;
        System.out.printf("You have withdrawn %d won.\n", amount);
        return this;
    }

    public void printBalance() {
        System.out.printf("Balance: %d\n\n", balance);
    }

    public void print() {
        System.out.println("Owner: " + owner);
        System.out.println("Account Number: " + accountNumber);
        printBalance();
    }


}