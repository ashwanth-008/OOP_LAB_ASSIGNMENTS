package OOP_CASE_BASED.CaseBased;

import java.util.*;

class Parameters {
    private double m; // mass of water in kg
    private double t1; // initial temp.
    private double t2; // final temp.

    Parameters(double m, double t1, double t2) {
        this.m = m;
        this.t1 = t1;
        this.t2 = t2;
    }

    public void set_m(double m) {
        this.m = m;
    }

    public void set_t1(double t1) {
        this.t1 = t1;
    }

    public void set_t2(double t2) {
        this.t2 = t2;
    }

    public double get_m() {
        return m;
    }

    public double get_t1() {
        return t1;
    }

    public double get_t2() {
        return t2;
    }

    public double calcEnergy(double m, double t1, double t2) {
        return (m * (t2 - t1)) * 4184;
    }
}

public class EnergyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mass of water in kg: ");
        double m = sc.nextDouble();
        System.out.println("Enter the initial temprature: ");
        double t1 = sc.nextDouble();
        System.out.println("Enter the final temperature: ");
        double t2 = sc.nextDouble();

        Parameters energy = new Parameters(m, t1, t2);
        System.out.println("The energy needed is " + energy.calcEnergy(m, t1, t2)+" joules.");

        sc.close();
    }
}
