import java.util.Scanner;

public class BankFraudDetection {

    static long suspiciousPairs = 0;

    public static void countSuspiciousPairs(long[] amounts, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            countSuspiciousPairs(amounts, left, mid);
            countSuspiciousPairs(amounts, mid + 1, right);

            int i = left;
            int j = mid + 1;

            while (i <= mid && j <= right) {
                if (amounts[i] > 3 * amounts[j]) {
                    suspiciousPairs += (mid - i + 1);
                    j++;
                } else {
                    i++;
                }
            }

            merge(amounts, left, mid, right);
        }
    }

    public static void merge(long[] amounts, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] leftArr = new long[n1];
        long[] rightArr = new long[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = amounts[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = amounts[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                amounts[k] = leftArr[i];
                i++;
            } else {
                amounts[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            amounts[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            amounts[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of transactions:");
        int n = sc.nextInt();

        long[] amounts = new long[n];

        System.out.println("Enter transaction amounts:");
        for (int i = 0; i < n; i++) {
            amounts[i] = sc.nextLong();
        }

        countSuspiciousPairs(amounts, 0, n - 1);

        System.out.println("Total suspicious transaction pairs: " + suspiciousPairs);

        sc.close();
    }
}