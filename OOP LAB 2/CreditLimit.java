/*Q6.) (Credit limit calculator) 
Develop a java application that determines whether any of several department - 
store customer has exceeded the credit limit on a charge account. 
For each customer following facts are available: 
 account number. 
 balance at the begining of the month. 
 total of all items charged by the customer this month. 
 total of all credits applied to the customers balance */
import java.util.Scanner;
public class CreditLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter beginning balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter total charges: ");
        double charges = sc.nextDouble();
        System.out.print("Enter total credits: ");
        double credits = sc.nextDouble();
        System.out.print("Enter credit limit: ");
        double limit = sc.nextDouble();
        double newBalance = balance + charges - credits;
        System.out.println("New Balance = " + newBalance);
        if (newBalance > limit)
            System.out.println("Credit limit exceeded!");
        sc.close();
    }
}
