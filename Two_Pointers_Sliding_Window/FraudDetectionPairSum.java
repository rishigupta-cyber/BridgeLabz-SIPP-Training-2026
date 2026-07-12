import java.util.Scanner;

public class FraudDetectionPairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        int[] transactions = new int[n];
        System.out.println("Enter transaction amounts (sorted):");
        for (int i = 0; i < n; i++) {
            transactions[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int[] result = findPairSum(transactions, target);

        if (result[0] == -1)
            System.out.println("No pair found that sums to " + target);
        else
            System.out.println("Suspicious pair found: " + result[0] + " + " + result[1] + " = " + target);

        sc.close();
    }

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target)
                return new int[]{transactions[left], transactions[right]};
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[]{-1, -1};
    }
}