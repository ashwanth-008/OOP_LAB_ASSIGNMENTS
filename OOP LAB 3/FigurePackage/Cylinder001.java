package FigurePackage;

public class Cylinder001 extends Figure001 {
    double h;

    public Cylinder001(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public void areaCalc() {
        a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    public void volCalc() {
        v = pi * r * r * h;
    }

    public void areaDisp() {
        System.out.println("Cylinder Area = " + a);
    }

    public void volDisp() {
        System.out.println("Cylinder Volume = " + v);
    }
}