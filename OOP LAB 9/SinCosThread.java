class SinThread extends Thread {
    double x;
    SinThread(double x) { 
        this.x = x; 
    }

    public void run() {
        System.out.println("sin(" + x + ") = " + Math.sin(x));
    }
}

class CosThread extends Thread {
    double x;
    CosThread(double x) { 
        this.x = x; 
    }

    public void run() {
        System.out.println("cos(" + x + ") = " + Math.cos(x));
    }
}

public class SinCosThread {
    public static void main(String[] args) {
        double x = Math.PI / 4;

        SinThread s = new SinThread(x);
        CosThread c = new CosThread(x);

        s.start();
        c.start();
    }
}