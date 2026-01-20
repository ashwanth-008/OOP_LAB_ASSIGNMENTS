//import java.util.Scanner;
public class InvoiceTest {
    public static void main(String[] args) 
    {
        Invoice item = new Invoice("A101", "Milk", 5, 250.0);
        System.out.println("Invoice Amount = " + item.getInvoiceAmount());
        item.setQuantity(10); //using setQuantity to set new quantity value
        System.out.println("Quantity now updated to 10.");
        System.out.println("Invoice Amount = " + item.getInvoiceAmount());
        //sc.close();
    }
    

}
