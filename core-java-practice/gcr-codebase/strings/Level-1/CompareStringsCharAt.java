import java.util.Scanner;

public class CompareStringsCharAt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String str1 = sc.next();
        System.out.println("Enter second string:");
        String str2 = sc.next();

        boolean result1 = compareUsingCharAt(str1, str2);
        boolean result2 = str1.equals(str2);

        System.out.println("Comparison using charAt(): " + result1);
        System.out.println("Comparison using equals(): " + result2);
        System.out.println("Both results match: " + (result1 == result2));

        sc.close();
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