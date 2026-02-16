import java.util.*;
class BMI {
    double weight, height;

    public BMI(double weight, double height) {
        this.height = height;
        this.weight = weight;
    }

    static final double pound = 0.45359237; // in kg
    static final double inch = 0.0254; // in meter

    public double BodyMassIndex() {
        return (weight * pound) / (Math.pow(height, 2.0) * Math.pow(inch, 2.0));
    }
}

public class BMICalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight in pounds: ");
        double weight = sc.nextDouble();
        System.out.println("Enter height in inches: ");
        double height = sc.nextDouble();
        BMI result = new BMI(weight, height);
        System.out.println("BMI is " + result.BodyMassIndex());
        sc.close();
    }
} 