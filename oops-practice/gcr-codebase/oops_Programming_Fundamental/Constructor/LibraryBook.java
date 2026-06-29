public class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println(title + " has been borrowed");
        } else {
            System.out.println(title + " is currently not available");
        }
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Wings of Fire", "A.P.J. Abdul Kalam", 250.0);
        book1.borrowBook();
        book1.borrowBook();
    }
}