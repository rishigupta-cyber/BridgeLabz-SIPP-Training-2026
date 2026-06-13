import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.next();

        generateException(text);
        handleException(text);

        sc.close();
    }

    public static void generateException(String text) {
        String sub = text.substring(5, 2);
        System.out.println(sub);
    }

    public static void handleException(String text) {
        try {
            String sub = text.substring(5, 2);
            System.out.println(sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}