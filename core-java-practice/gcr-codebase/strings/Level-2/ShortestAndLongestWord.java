import java.util.Scanner;

public class ShortestAndLongestWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordLengths = getWordsWithLengths(words);
        int[] shortestLongest = findShortestAndLongest(wordLengths);

        System.out.println("Shortest word: " + wordLengths[shortestLongest[0]][0]
                + " (length " + wordLengths[shortestLongest[0]][1] + ")");
        System.out.println("Longest word: " + wordLengths[shortestLongest[1]][0]
                + " (length " + wordLengths[shortestLongest[1]][1] + ")");

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

    public static String[] splitWords(String text) {
        int length = findLength(text);
        int wordCount = 1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx] = i;
                idx++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = text.substring(start, length);

        return words;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordLengths.length; i++) {
            int currentLength = Integer.parseInt(wordLengths[i][1]);
            int shortestLength = Integer.parseInt(wordLengths[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordLengths[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[] { shortestIndex, longestIndex };
    }
}