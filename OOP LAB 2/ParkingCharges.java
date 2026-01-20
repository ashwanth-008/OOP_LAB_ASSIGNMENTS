/*A parking garage charges a $2.00 minimum fee to park for up to three hours. 
The garage charges an additional $0.50 per hours for each hours or part thereof in excess of three hours. 
The maximum charge for any given 24-hours period is $10.00.
Assume that no car parks for longer than 24 hours at a time. 
Write an application that calculates and displays the parking charges for each customers who parked in the garage yesterday. 
You should enter the hours parked for each customers . 
The program should display the charge for the current customers 
and should calculate and display the running total of yesterday's receipts. 
It should use the method calculate charges to determine the charge for each customer. */
import java.util.Scanner;
public class ParkingCharges {
    public static double calculateCharges(double hours) {    //method
        double charge = 2.0;
        if (hours > 3)
            charge += Math.ceil(hours - 3) * 0.5;
        if (charge > 10)
            charge = 10;
        return charge;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter hours parked for customer " + i + ": ");
            double hours = sc.nextDouble();
            double charge = calculateCharges(hours);
            total += charge;

            System.out.println("Charge = " + charge);
        }
        System.out.println("Total receipts = " + total);
        sc.close();
    }
}
