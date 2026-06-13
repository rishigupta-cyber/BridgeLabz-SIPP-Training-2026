import java.util.Scanner;

public class TrimStringCharAt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string with leading/trailing spaces:");
        String text = sc.nextLine();

        int[] trimIndexes = findTrimIndexes(text);
        String customTrimmed = getSubstring(text, trimIndexes[0], trimIndexes[1]);
        String builtInTrimmed = text.trim();

        System.out.println("Custom trimmed: [" + customTrimmed + "]");
        System.out.println("Built-in trimmed: [" + builtInTrimmed + "]");
        System.out.println("Results match: " + compareUsingCharAt(customTrimmed, builtInTrimmed));

        sc.close();
    }

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length();

        while (start < end && text.charAt(start) == ' ') {
            start++;
        }

        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    public static String getSubstring(String text, int start, int end) {
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