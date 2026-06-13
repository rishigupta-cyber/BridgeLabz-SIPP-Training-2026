import java.util.Scanner;

public class CharacterFrequencyFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.println("Character\tFrequency");
        for (String[] row : result) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }

        sc.close();
    }

    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[(int) ch]++;
        }

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[(int) ch]);
        }

        return result;
    }
}