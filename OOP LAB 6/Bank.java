import java.util.Scanner;
class Bank {
    double deposit(double amount, double balance) {
        balance = balance + amount;
        return balance;
    }
    double withdraw(double amount, double balance) {
        if (balance >= amount) {
            balance = balance - amount;
            return balance;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Bank b = new Bank();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter balance and deposit respectively.");
        Double bal = sc.nextDouble();
        Double dep = sc.nextDouble();
        bal = b.deposit(dep, bal);
        System.out.println("After Deposit: " + bal);
        System.out.println("Enter withdraw amount.");
        Double with = sc.nextDouble();
        bal = b.withdraw(with, bal);
        System.out.println("After Withdraw: " + bal);
    }
}