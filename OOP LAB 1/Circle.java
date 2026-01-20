import java.util.Scanner;
public class Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        int r = sc.nextInt();
        double diameter = 2 * r;
        double circumference = 2 * Math.PI * r;   //Math.PI = 3.141592653589793
        double area = Math.PI * r * r;
        System.out.println("Diameter = " + diameter);
        System.out.println("Circumference = " + circumference);
        System.out.println("Area = " + area);
        sc.close();
    }
}
