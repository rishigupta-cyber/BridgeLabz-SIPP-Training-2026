public class book {
    String title;
    String author;
    double price;

    book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println(title + " by " + author + " - Rs." + price);
    }

    public static void main(String[] args) {
        book b1 = new book();
        book b2 = new book("The Alchemist", "Paulo Coelho", 299.0);
        b1.display();
        b2.display();
    }
}