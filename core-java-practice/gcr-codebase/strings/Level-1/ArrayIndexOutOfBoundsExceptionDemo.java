import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter name " + (i + 1) + ":");
            names[i] = sc.next();
        }

        generateException(names);
        handleException(names);

        sc.close();
    }

    public static void generateException(String[] names) {
        System.out.println(names[names.length + 2]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length + 2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}