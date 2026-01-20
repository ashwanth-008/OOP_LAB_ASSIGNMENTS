/* Q2.) Create a class called invoice that hardware store might use to represent an invoice for an item sold at the store. 
An invoice should include four pieces of information as instance variable 
-> a part number(type string) 
-> a part description(type string) 
-> a quantity of the item being purchased(type int) 
-> a price per item(double) 
Your class should have a constructor that initialises the four instance variable . 
Provide a set and a get method for each instance variable . 
In addition provide method named getInvoiceAmount that calculate the invoice amount(i.e. multiplies the quantity per item ), 
then return the amount as a double value.
If the quantity is not positive it should be set to 0. 
If the price per item is not positive it should be set to 0.0. 
Write test application named invoice test that demonstration class invoice capabilities. */
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) { //constructor only works once for initialization
        this.partNumber = partNumber;                                                                // cannot update data without setquantity and getquantity
        this.partDescription = partDescription;
        this.quantity = (quantity > 0) ? quantity : 0;
        this.pricePerItem = (pricePerItem > 0) ? pricePerItem : 0.0;
    }
    public void setQuantity(int quantity) {              //this is a setter, we're using it because
        this.quantity = (quantity > 0) ? quantity : 0;   //quantity is private, hence Invoice.quantity = xxx 
                                                         // wont work outside Invoice class + can update data afterwards 
    }
    public int getQuantity() {                           //this is getter
        return quantity;
    }
    public void setPricePerItem(double price) {          //similar for priceperitem
        this.pricePerItem = (price > 0) ? price : 0.0;
    }
    public double getPricePerItem() 
    { 
        return pricePerItem;
    }
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}

