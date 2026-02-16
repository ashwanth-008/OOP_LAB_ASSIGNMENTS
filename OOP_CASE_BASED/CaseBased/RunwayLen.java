//package OOP_CASE_BASED.CaseBased;

import java.util.*;
class LengthCalc {
    double speed, a; // a=acceleration

    LengthCalc(double speed, double a) {
        this.speed = speed;
        this.a = a;
    }

    public double Length(double speed, double a) {
        return (speed * speed) / (2.0 * a);
    }
}

public class RunwayLen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter speed and acceleration respectively: ");
        double speed = sc.nextDouble();
        double a = sc.nextDouble();
        LengthCalc runway = new LengthCalc(speed, a);
        System.out.println("The minimum runway length for this airplane is " + runway.Length(speed, a));
        sc.close();
    }

}