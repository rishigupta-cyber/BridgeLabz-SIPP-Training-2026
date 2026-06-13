import java.util.Scanner;

public class VowelConsonantCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        int[] counts = countVowelsConsonants(text);

        System.out.println("Vowel count: " + counts[0]);
        System.out.println("Consonant count: " + counts[1]);

        sc.close();
    }

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    public static int[] countVowelsConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }

        return new int[] { vowelCount, consonantCount };
    }
}