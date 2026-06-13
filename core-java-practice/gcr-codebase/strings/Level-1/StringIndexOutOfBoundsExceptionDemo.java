import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.next();

        generateException(text);
        handleException(text);

        sc.close();
    }

    public static void generateException(String text) {
        char c = text.charAt(text.length() + 5);
        System.out.println(c);
    }

    public static void handleException(String text) {
        try {
            char c = text.charAt(text.length() + 5);
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}