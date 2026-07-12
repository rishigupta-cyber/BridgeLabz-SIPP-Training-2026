import java.util.Scanner;

public class EmployeePromotionConflicts {

    static long conflictCount = 0;

    public static void countConflicts(int[] scores, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            countConflicts(scores, left, mid);
            countConflicts(scores, mid + 1, right);
            merge(scores, left, mid, right);
        }
    }

    public static void merge(int[] scores, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = scores[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = scores[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                conflictCount += (n2 - j);
                scores[k] = leftArr[i];
                i++;
            } else {
                scores[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            scores[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            scores[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of employees:");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter performance scores of employees:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        countConflicts(scores, 0, n - 1);

        System.out.println("Total promotion conflicts: " + conflictCount);

        sc.close();
    }
}