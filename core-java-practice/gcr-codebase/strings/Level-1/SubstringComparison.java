import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.next();
        System.out.println("Enter start index:");
        int start = sc.nextInt();
        System.out.println("Enter end index:");
        int end = sc.nextInt();

        String sub1 = getSubstringUsingCharAt(text, start, end);
        String sub2 = text.substring(start, end);

        System.out.println("Substring using charAt(): " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        System.out.println("Substrings are equal: " + compareUsingCharAt(sub1, sub2));

        sc.close();
    }

    public static String getSubstringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
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