import java.util.HashMap;
import java.util.Map;

public class FraudPairDetection {
    public static int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(amounts[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] amounts = {5000, 3000, 7000, 2000, 9000};
        int target = 10000;

        int[] result = findFraudPair(amounts, target);
        if (result[0] == -1) {
            System.out.println("No fraud pair found");
        } else {
            System.out.println("Fraud pair found at indices: " + result[0] + ", " + result[1]);
        }
    }
}