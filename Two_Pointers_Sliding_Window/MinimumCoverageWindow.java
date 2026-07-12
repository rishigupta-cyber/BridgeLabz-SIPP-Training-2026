import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MinimumCoverageWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the log string (s): ");
        String s = sc.next();

        System.out.print("Enter the error code characters to find (t): ");
        String t = sc.next();

        String result = minWindowSubstring(s, t);

        if (result.isEmpty())
            System.out.println("No valid window found containing all characters of: " + t);
        else
            System.out.println("Minimum coverage window: \"" + result + "\"");

        sc.close();
    }

    public static String minWindowSubstring(String s, String t) {
        if (s.isEmpty() || t.isEmpty())
            return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.merge(c, 1, Integer::sum);

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            window.merge(c, 1, Integer::sum);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue())
                formed++;

            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar))
                    formed--;

                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}