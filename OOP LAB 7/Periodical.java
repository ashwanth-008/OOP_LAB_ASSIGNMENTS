class Book {
    int bookId;
    String title;
    String author;
    double price;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Periodical extends Book {
    String period;   // weekly, monthly, etc.

    Periodical(int bookId, String title, String author, double price, String period) {
        super(bookId, title, author, price);   // calling parent constructor
        this.period = period;
    }

    void modifyDetails(double newPrice, String newPeriod) {
        this.price = newPrice;
        this.period = newPeriod;
    }

    // Overriding display method
    void display() {
        super.display();   // (super calls method from parent even though its being overriden)
        System.out.println("Period: " + period);
    }

    // Main Method
    public static void main(String[] args) {

        Periodical p = new Periodical(101, "TechTalks", "John Legend", 200, "Monthly");

        System.out.println("Before Modification:");
        p.display();

        p.modifyDetails(250, "Weekly");

        System.out.println("\nAfter modification of price and period:");
        p.display();
    }
}
