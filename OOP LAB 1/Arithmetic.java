
import calculator.Operations;
import java.util.Scanner;
public class Arithmetic {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first integer - ");
        int num1= sc.nextInt();
        System.out.println("Enter second integer - ");
        int num2= sc.nextInt();
        Operations op= new Operations();
        System.out.println("Sum = "+op.sum(num1,num2));
        System.out.println("Difference = "+op.difference(num1,num2));
        System.out.println("Product = "+op.product(num1,num2));
        System.out.println("Quotient = "+op.quotient(num1,num2));
        sc.close();
    }
}
