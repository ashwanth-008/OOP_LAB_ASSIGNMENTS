import java.util.*;

class Player extends Thread {
    int number;
    int input;

    Player(int input) {
        this.input = input;
    }

    public void run() {
        Random r = new Random();
        number = r.nextInt(100);
        System.out.println(Thread.currentThread().getName() + " got: " + number);
    }
}

public class TwoPlayer {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Player 1 enter number: ");
        int a = sc.nextInt();

        System.out.print("Player 2 enter number: ");
        int b = sc.nextInt();

        Player p1 = new Player(a);
        Player p2 = new Player(b);

        p1.setName("Player 1");
        p2.setName("Player 2");

        p1.start();
        p2.start();

        p1.join();
        p2.join();
        if (p1.number > p2.number) {
            System.out.println("Player 1 wins with points: " + (p1.number - p2.number));
        } else if (p2.number > p1.number) {
            System.out.println("Player 2 wins with points: " + (p2.number - p1.number));
        } else {
            System.out.println("It's a tie!");
        }
    }
}