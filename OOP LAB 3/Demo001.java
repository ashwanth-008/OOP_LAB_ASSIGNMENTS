import FigurePackage.*;

public class Demo001 {
    public static void main(String[] args) {

        Figure001 f = new Cone001(3, 7, 8);
        f.areaCalc();
        f.volCalc();
        f.areaDisp();
        f.volDisp();

        Figure001 f1 = new Sphere001(5);
        f1.areaCalc();
        f1.volCalc();
        f1.areaDisp();
        f1.volDisp();

        Figure001 f2 = new Cylinder001(4, 10);
        f2.areaCalc();
        f2.volCalc();
        f2.areaDisp();
        f2.volDisp();
    }
}
