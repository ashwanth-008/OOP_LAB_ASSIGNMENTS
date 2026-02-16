package OOP_CASE_BASED.CaseBased;

import java.util.*;

class AccelerationCalc {
    private float v1;
    private float v2;
    private float t;

    public AccelerationCalc(float v1, float v2, float t) {
        this.v1 = v1;
        this.v2 = v2;
        this.t = t;
    }

    public void setV1(float v1) {         //setters
        this.v1 = v1;
    }

    public void setV2(float v2) {
        this.v2 = v2;
    }

    public void setT(float t) {
        this.t = t;
    }

    public float getV1() {
        return v1;
    }

    public float getV2() {             //getters
        return v2;
    }

    public float getT() {
        return t;
    }

    public float getAcceleration(float v1, float v2, float t) {
        return (v2 - v1) / t;
    }
}

public class AvgAcc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter v1 v2 and t respectively:");
        float v1 = sc.nextFloat();
        float v2 = sc.nextFloat();
        float t = sc.nextFloat();
        AccelerationCalc acceleration = new AccelerationCalc(v1, v2, t);
        System.out.println("The acceleration is " + acceleration.getAcceleration(v1, v2, t)+" m/s²");
        sc.close();

    }
}