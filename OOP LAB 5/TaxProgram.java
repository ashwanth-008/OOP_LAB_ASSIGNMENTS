import java.util.Scanner;
public class TaxProgram {

    static double calculateTax(double grossPay) {
        return grossPay * 0.15;
    }

    static double calculateNetPay(int hoursWork) {
        double grossPay = hoursWork * 12;
        double tax = calculateTax(grossPay);
        return grossPay - tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER HOURS WORKED.");
        int hours = sc.nextInt();
        double netPay = calculateNetPay(hours);
        System.out.println("Net Pay: $" + netPay);
    }
}
