public class SmartLibrarySystem {
    static String books[] = {"Java", "Python", null, "C++"};

    static void getBookLength(int index) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("No book exists at index " + index + ". Valid range: 0 to " + (books.length - 1) + ".");
            }
            if (books[index] == null) {
                throw new NullPointerException("Book entry at index " + index + " is null. No name to measure.");
            }
            System.out.println("Book at index " + index + ": \"" + books[index] + "\" | Length: " + books[index].length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null Entry Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getBookLength(0);
        getBookLength(1);
        getBookLength(2);
        getBookLength(3);
        getBookLength(7);
        getBookLength(-1);
    }
}