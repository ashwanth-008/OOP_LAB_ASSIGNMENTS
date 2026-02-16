import java.util.Scanner;
public class Fruit {
    String name;
    String type; // for single or bunch of fruit(s)
    double price;

    Fruit(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    void displayFruit() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER FRUIT NAME, TYPE AND PRICE RESPECTIVELY.");
        String name = sc.nextLine();
        String type = sc.nextLine();
        int price = sc.nextInt();
        sc.nextLine();
        Fruit f1 = new Fruit(name,type,price);
        System.out.println("ENTER ANOTHER FRUIT NAME, TYPE AND PRICE RESPECTIVELY.");
        String name2 = sc.nextLine();
        String type2 = sc.nextLine();
        int price2 = sc.nextInt();
        Fruit f2 = new Fruit(name2,type2,price2);
        f1.displayFruit();
        f2.displayFruit();
    }
}

