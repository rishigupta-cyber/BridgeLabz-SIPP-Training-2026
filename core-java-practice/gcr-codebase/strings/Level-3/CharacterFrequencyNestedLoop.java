import java.util.Scanner;

public class CharacterFrequencyNestedLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        System.out.println("Character with Frequency:");
        for (String entry : result) {
            if (entry != null) {
                System.out.println(entry);
            }
        }

        sc.close();
    }

    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }

        String[] result = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[i] = chars[i] + " - " + frequency[i];
            }
        }

        return result;
    }
}