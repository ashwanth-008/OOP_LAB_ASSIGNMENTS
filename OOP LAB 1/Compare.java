import comparetwonos.CompareNumbers;
import java.util.Scanner;
public class Compare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first integer - ");
        int num1= sc.nextInt();
        System.out.println("Enter second integer - ");
        int num2= sc.nextInt();
        CompareNumbers cmp = new CompareNumbers();
        String result = cmp.compare(num1,num2);
        System.out.println(result);
        sc.close();
    }
}
