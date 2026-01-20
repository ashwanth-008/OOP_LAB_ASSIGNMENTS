/*Q1) Create an application that calculate your daily driving cost , 
so that you can estimate how much money could be saved by car pooling 
which also has other advantages such as reducing carbon emission and traffic congestion . 
The application should input the following information and display the user's cost per day of driving to work.
  a)total miles driven per day
  b)cost per gallon of gasoline 
  c)average fees per day 
  d)tolls per day */
import java.util.Scanner;
public class Drivingcost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total miles driven per day: ");
        double miles = sc.nextDouble();
        System.out.print("Enter cost per gallon of gasoline (USD): ");
        double costPerGallon = sc.nextDouble();
        System.out.print("Enter average parking fees per day (USD): ");
        double parkingFees = sc.nextDouble();
        System.out.print("Enter tolls per day: ");
        double tolls = sc.nextDouble();
        double gallonsUsed = miles / 30;     //assuming 30 miles/gallon
        double fuelCost = gallonsUsed * costPerGallon;
        double totalCost = fuelCost + parkingFees + tolls;
        System.out.println("Daily driving cost = " + totalCost + " USD");
        sc.close();
    }
}
