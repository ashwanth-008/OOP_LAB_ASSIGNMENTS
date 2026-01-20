import java.util.Scanner;
public class Digiseparate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter five-digit number: ");
        int num = sc.nextInt();

        System.out.print((num / 10000) + "   ");
        System.out.print((num / 1000) % 10 + "   ");
        System.out.print((num / 100) % 10 + "   ");
        System.out.print((num / 10) % 10 + "   ");
        System.out.print(num % 10);

        sc.close();
    }
}
