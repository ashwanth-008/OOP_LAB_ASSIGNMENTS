import java.util.Scanner;
class Product {
    int productID;
    String name;
    int categoryID;
    double unitPrice;

    Product(int productID, String name, int categoryID, double unitPrice) {
        this.productID = productID;
        this.name = name;
        this.categoryID = categoryID;
        this.unitPrice = unitPrice;
    }
}

public class ElectricalProduct extends Product {
    String voltageRange;
    int wattage;

    ElectricalProduct(int productID, String name, int categoryID,
                      double unitPrice, String voltageRange, int wattage) {
        super(productID, name, categoryID, unitPrice);
        this.voltageRange = voltageRange;
        this.wattage = wattage;
    }

    void updateDetails(int newWattage, double newPrice) {
        this.wattage = newWattage;
        this.unitPrice = newPrice;
    }

    void display() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Category ID: " + categoryID);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Voltage Range: " + voltageRange);
        System.out.println("Wattage: " + wattage);
    }

    public static void main(String[] args) {
        ElectricalProduct ep = new ElectricalProduct(101, "Heater", 5, 2500, "220-240V", 1000);
        System.out.println("BEFORE UPDATION");
        ep.display();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new wattage and new price respectively to be updated.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        ep.updateDetails(a,b);
        System.out.println("AFTER UPDATION");
        ep.display();
    }
}

