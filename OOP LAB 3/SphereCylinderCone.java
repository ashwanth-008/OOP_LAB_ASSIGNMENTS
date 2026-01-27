abstract class Figure2 {
    double a, v;
    final double pi = 22/7;

    public abstract void calcArea();
    public abstract void calcVol();
    public abstract void dispArea();
    public abstract void dispVol();
}

class Cone extends Figure2 {
    double r, h, s;

    Cone(double x, double y, double z) {
        r = x;
        h = y;
        s = z;
    }

    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void calcVol() {
        v = (pi * r * r * h) / 3;
    }

    public void dispArea() {
        System.out.println("Cone Area = " + a);
    }

    public void dispVol() {
        System.out.println("Cone Volume = " + v);
    }
}

class Sphere extends Figure2 {
    double r;

    Sphere(double x) {
        r = x;
    }

    public void calcArea() {
        a = 4 * pi * r * r;
    }

    public void calcVol() {
        v = (4 * pi * r * r * r) / 3;
    }

    public void dispArea() {
        System.out.println("Sphere Area = " + a);
    }

    public void dispVol() {
        System.out.println("Sphere Volume = " + v);
    }
}

class Cylinder extends Figure2 {
    double r, h;

    Cylinder(double x, double y) {
        r = x;
        h = y;
    }

    public void calcArea() {
        a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    public void calcVol() {
        v = pi * r * r * h;
    }

    public void dispArea() {
        System.out.println("Cylinder Area = " + a);
    }

    public void dispVol() {
        System.out.println("Cylinder Volume = " + v);
    }
}

public class SphereCylinderCone {
    public static void main(String[] args) {

        Figure2 f;

        f = new Cone(5, 8, 10);
        f.calcArea();
        f.calcVol();
        f.dispArea();
        f.dispVol();

        f = new Sphere(6);
        f.calcArea();
        f.calcVol();
        f.dispArea();
        f.dispVol();

        f = new Cylinder(4, 9);
        f.calcArea();
        f.calcVol();
        f.dispArea();
        f.dispVol();
    }
}
