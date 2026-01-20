/* (Gas mileage ) Drivers are concerned with the mileage their automobiles get. 
One driver has kept track of several trips by recording the miles driven and gallons used for each tankful.
Develop a java application that will input the miles driven and gallons used (both as in) for each trip.
The program should calculate and display the miles per gallon obtained for each trip 
and print the combined miles per gallon obtained for all trips up to this point. 
All averaging calculate should produce floating point results. 
Use class scanner and sentinel-controlled repetition to obtain the data from the user. */
import java.util.Scanner;
public class GasMileage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalMiles = 0;
        int totalGallons = 0;
        while (true) {
            System.out.print("Enter miles driven (-1 to stop): ");
            int miles = sc.nextInt();
            if (miles == -1)
                break;
            System.out.print("Enter gallons used: ");
            int gallons = sc.nextInt();
            double mpg = (double) miles / gallons;
            System.out.println("Miles per gallon: " + mpg);
            totalMiles += miles;
            totalGallons += gallons;
        }
        if (totalGallons != 0)
            System.out.println("Combined MPG = " + (double) totalMiles / totalGallons);
        sc.close();
    }
}
