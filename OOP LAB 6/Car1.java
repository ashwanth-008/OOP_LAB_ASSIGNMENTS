abstract class Car {
    String brand = "Car Brand";
    void start() {     // concrete method
        System.out.println("Car Started");
    }

    abstract void avg();   // abstract methods avg and mode
    abstract void mode();  
}
class Maruti extends Car {
    void avg() {
        System.out.println("Maruti Average: 20 kmpl");
    }

    void mode() {
        System.out.println("Maruti Mode: Manual");
    }
}
class Santro extends Car {
    void avg() {
        System.out.println("Santro Average: 18 kmpl");
    }

    void mode() {
        System.out.println("Santro Mode: Automatic");
    }
}
class Car1 {
    public static void main(String[] args) {
        Car c;
        c = new Maruti();
        c.start();
        c.avg();
        c.mode();

        c = new Santro();
        c.start();
        c.avg();
        c.mode();
    }
}
