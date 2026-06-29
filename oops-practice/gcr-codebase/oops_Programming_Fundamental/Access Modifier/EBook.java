class Book {
    public String isbn;
    protected String title;
    private String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

public class EBook extends Book {
    double fileSizeMB;

    EBook(String isbn, String title, String author, double fileSizeMB) {
        super(isbn, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    void displayEbookDetails() {
        System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + getAuthor() + ", Size: " + fileSizeMB + "MB");
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-3-16-148410-0", "Java Fundamentals", "James Gosling", 12.5);
        ebook.displayEbookDetails();

        ebook.setAuthor("James A. Gosling");
        System.out.println("Updated author: " + ebook.getAuthor());
    }
}