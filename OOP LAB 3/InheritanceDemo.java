class Figure {
    double r, a, v;

    public void dispArea() {
        System.out.println("Area = " + a);
    }

    public void dispVol() {
        System.out.println("Volume = " + v);
    }
}
class Cone extends Figure {
    // all methods of Figure are now available in Cone
    double h, s;
    final double pi = 22/7;

    public Cone(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void calcVol() {
        v = (pi * r * r * h) / 3;
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        Cone c = new Cone(7, 10, 12);
        c.calcArea();
        c.calcVol();
        c.dispArea();
        c.dispVol();
    }
}

