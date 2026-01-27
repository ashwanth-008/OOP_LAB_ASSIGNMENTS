package FigurePackage;

public class Sphere001 extends Figure001 {

    public Sphere001(double r) {
        this.r = r;
    }

    public void areaCalc() {
        a = 4 * pi * r * r;
    }

    public void volCalc() {
        v = (4 * pi * r * r * r) / 3;
    }

    public void areaDisp() {
        System.out.println("Sphere Area = " + a);
    }

    public void volDisp() {
        System.out.println("Sphere Volume = " + v);
    }
}