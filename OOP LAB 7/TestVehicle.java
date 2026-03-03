class Vehicle {
    String brand;
    int maxSpeed;

    // Constructor
    Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    void maxSpeed() {
        System.out.println("Vehicle Max Speed: " + maxSpeed + " km/h");
    }
}


class Car extends Vehicle {
    int Doors;
  
    Car(String brand, int maxSpeed, int Doors) {
        super(brand, maxSpeed);   // CALLING PARENT CONSTRUCTOR
        this.Doors = Doors;
    }

    void maxSpeed() {
        System.out.println("Car Brand: " + brand);                   //OVERRIDING METHOD OF PARENT CLASS
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("No. of doors : " + Doors);
    }
}


class Bicycle extends Vehicle {
    int passenger;
    Bicycle(String brand, int maxSpeed, int passenger) {
        super(brand, maxSpeed);
        this.passenger = passenger;
    }

    void maxSpeed() {
        System.out.println("Bicycle Brand: " + brand);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("No. of passengers : " + passenger);
    }
}

class Scooter extends Vehicle {
    int passenger;
    Scooter(String brand, int maxSpeed, int passenger) {
        super(brand, maxSpeed);
        this.passenger = passenger;
    }
    void maxSpeed() {
        System.out.println("Scooter Brand: " + brand);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("No. of passengers : " + passenger);
    }
}


class TestVehicle {
    public static void main(String[] args) {

        Car car = new Car("Toyota", 180, 4);
        Bicycle bicycle = new Bicycle("Hero", 40, 1);
        Scooter scooter = new Scooter("Honda", 90, 2);

        car.maxSpeed();
        System.out.println();

        bicycle.maxSpeed();
        System.out.println();

        scooter.maxSpeed();
    }
}
