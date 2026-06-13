import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        boolean result1 = checkPalindromeIterative(text);
        boolean result2 = checkPalindromeRecursive(text, 0, text.length() - 1);
        boolean result3 = checkPalindromeUsingArrays(text);

        System.out.println("Palindrome check using iterative logic: " + result1);
        System.out.println("Palindrome check using recursive logic: " + result2);
        System.out.println("Palindrome check using character arrays: " + result3);

        sc.close();
    }

    public static boolean checkPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean checkPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return checkPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }

        return reversed;
    }

    public static boolean checkPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }
}