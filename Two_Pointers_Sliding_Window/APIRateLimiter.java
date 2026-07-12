import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class APIRateLimiter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of API requests: ");
        int n = sc.nextInt();

        int[] keyIds = new int[n];
        System.out.println("Enter API key IDs for each request:");
        for (int i = 0; i < n; i++) {
            keyIds[i] = sc.nextInt();
        }

        System.out.print("Enter max distinct API keys allowed (N): ");
        int N = sc.nextInt();

        int result = longestSubarrayWithAtMostNDistinct(keyIds, N);
        System.out.println("Longest contiguous request window with at most " + N + " distinct keys: " + result);

        sc.close();
    }

    public static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < keyIds.length; end++) {
            freq.merge(keyIds[end], 1, Integer::sum);

            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);

                if (freq.get(leftKey) == 0)
                    freq.remove(leftKey);

                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}