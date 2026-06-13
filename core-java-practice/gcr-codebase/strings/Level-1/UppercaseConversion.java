import java.util.Scanner;

public class UppercaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String manualUpper = toUpperManual(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("Manual uppercase: " + manualUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Results match: " + compareUsingCharAt(manualUpper, builtInUpper));

        sc.close();
    }

    public static String toUpperManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result = result + ch;
        }
        return result;
    }

    public static boolean compareUsingCharAt(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}