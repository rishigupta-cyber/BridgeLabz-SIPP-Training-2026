import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        char result = findFirstNonRepeating(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }

    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[(int) ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[(int) ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }
}