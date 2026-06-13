import java.util.Scanner;

public class LowercaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String manualLower = toLowerManual(text);
        String builtInLower = text.toLowerCase();

        System.out.println("Manual lowercase: " + manualLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Results match: " + compareUsingCharAt(manualLower, builtInLower));

        sc.close();
    }

    public static String toLowerManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
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