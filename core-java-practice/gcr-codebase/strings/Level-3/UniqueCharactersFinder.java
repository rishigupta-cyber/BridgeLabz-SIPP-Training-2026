import java.util.Scanner;

public class UniqueCharactersFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("Unique characters:");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }

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

    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] tempArray = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = tempArray[i];
        }

        return result;
    }
}