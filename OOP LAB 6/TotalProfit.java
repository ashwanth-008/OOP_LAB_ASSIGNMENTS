import java.util.Scanner;
class TotalProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of attendees for the show: ");
        int attendees = sc.nextInt();
        double income = attendees * 5;
        double cost = 20 + (0.5 * attendees);
        double profit = income - cost;
        System.out.println("Total profit from this show: $" + profit);
    }
}
