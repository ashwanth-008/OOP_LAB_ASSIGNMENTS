class FibonacciThread extends Thread {
    public void run() {
        int a = 1, b = 1;
        System.out.println("Fibonacci Series:");

        for (int i = 1; i <= 50; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }

        try {
            System.out.println("\nFibonacci thread sleeping...");
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

class PrimeThread extends Thread {
    public void run() {
        System.out.println("\nPrime Numbers:");

        int count = 0, num = 2;

        while (count < 25) {
            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }
}

public class FiboOrPrime {
    public static void main(String[] args) {
        FibonacciThread f = new FibonacciThread();
        PrimeThread p = new PrimeThread();

        f.setPriority(8);
        p.setPriority(5);

        f.start();
        p.start();
    }
}