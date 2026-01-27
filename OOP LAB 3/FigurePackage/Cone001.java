package FigurePackage;

public class Cone001 extends Figure001 {
    double h, s;

    public Cone001(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    public void areaCalc() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void volCalc() {
        v = (pi * r * r * h) / 3;
    }

    public void areaDisp() {
        System.out.println("Cone Area = " + a);
    }

    public void volDisp() {
        System.out.println("Cone Volume = " + v);
    }
}