public class LibraryManagementSystem {
    final String isbn;
    String title;
    String author;
    static String libraryName = "City Central Library";

    LibraryManagementSystem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void displayDetails(Object obj) {
        if (obj instanceof LibraryManagementSystem) {
            System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
        }
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public static void main(String[] args) {
        LibraryManagementSystem b1 = new LibraryManagementSystem("Java Fundamentals", "James Gosling", "ISBN-1001");
        LibraryManagementSystem b2 = new LibraryManagementSystem("Wings of Fire", "A.P.J. Abdul Kalam", "ISBN-1002");

        b1.displayDetails(b1);
        b2.displayDetails(b2);

        LibraryManagementSystem.displayLibraryName();
    }
}