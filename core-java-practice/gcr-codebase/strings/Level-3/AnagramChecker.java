import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter second string:");
        String str2 = sc.nextLine();

        boolean result = checkAnagram(str1, str2);
        System.out.println("Anagram check result: " + result);

        sc.close();
    }

    public static boolean checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            frequency1[(int) str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            frequency2[(int) str2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }
}