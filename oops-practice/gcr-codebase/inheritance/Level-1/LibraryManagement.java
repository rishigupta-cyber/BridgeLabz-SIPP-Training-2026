public class LibraryManagement {

    static class Book {
        String title;
        int publicationYear;

        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }
    }

    static class Author extends Book {
        String name;
        String bio;

        Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        void displayInfo() {
            System.out.println("Title: " + title + " | Published: " + publicationYear);
            System.out.println("Author: " + name + " | Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        Author a1 = new Author("Wings of Fire", 1999, "A.P.J. Abdul Kalam", "Former President of India and renowned scientist");
        Author a2 = new Author("The Alchemist", 1988, "Paulo Coelho", "Brazilian novelist known for philosophical fiction");

        a1.displayInfo();
        a2.displayInfo();
    }
}