package day06;

public class Ex03 {
    public static void main(String[] args) {
        BankAccount MyAccount = new BankAccount("Harry Potter", 13275);

        MyAccount.print();
        MyAccount.deposit(10000).printBalance();
        MyAccount.withdraw(5000).printBalance();
    }
}
