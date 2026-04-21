class Account {
    int balance = 600;

    synchronized void deposit(int amt) throws InterruptedException { //father only deposits when amount<2000
        while (balance >= 2000) {
            wait(); // wait if already enough money
        }

        balance += amt;
        System.out.println("Father deposits: " + amt + " | Balance: " + balance);

        notify(); // wake up son
    }

    synchronized void withdraw(int amt) throws InterruptedException { //son only withdraws when amount>2000
        while (balance <= 2000) {
            wait(); // wait until enough balance
        }

        balance -= amt;
        System.out.println("Son withdraws: " + amt + " | Balance: " + balance);

        notify(); // wake up father
    }
}

class Father extends Thread {
    Account acc;

    Father(Account acc) {
        this.acc = acc;
    }

    public void run() {
        try {
            while (true) {
                int amt = (int)(Math.random() * 200) + 1;
                acc.deposit(amt);
                Thread.sleep(500);
            }
        } catch (Exception e) {}
    }
}

class Son extends Thread {
    Account acc;

    Son(Account acc) {
        this.acc = acc;
    }

    public void run() {
        try {
            while (true) {
                int amt = (int)(Math.random() * 150) + 1;
                acc.withdraw(amt);
                Thread.sleep(500);
            }
        } catch (Exception e) {}
    }
}

public class FatherSonSync {
    public static void main(String[] args) {
        Account acc = new Account();

        Father f = new Father(acc);
        Son s = new Son(acc);

        f.start();
        s.start();
    }
}