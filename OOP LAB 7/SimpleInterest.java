import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Principal Amount: ");
            double principal = sc.nextDouble();

            System.out.print("Enter Annual Interest Rate (%): ");
            double rate = sc.nextDouble();

            System.out.print("Enter Number of Months: ");
            int months = sc.nextInt();

            double years = months / 12.0;
            double interest = principal * (rate / 100) * years;
            double balance = principal + interest;

            System.out.println("Total Interest: " + interest);
            System.out.println("Final Balance: " + balance);

        } catch (Exception e) { //CATCHES ANY SORT OF EXCEPTION
            System.out.println("Invalid Input! Please enter correct values.");
        }

        sc.close();
    }
}