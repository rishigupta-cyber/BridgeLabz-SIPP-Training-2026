import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.next();

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        sc.close();
    }

    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
}