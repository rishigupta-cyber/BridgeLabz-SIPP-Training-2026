import java.util.Scanner;

public class WebsiteResponseAnalysis {

    static long violationCount = 0;

    public static void countViolations(int[] times, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            countViolations(times, left, mid);
            countViolations(times, mid + 1, right);
            merge(times, left, mid, right);
        }
    }

    public static void merge(int[] times, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = times[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = times[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                times[k] = leftArr[i];
                i++;
            } else {
                violationCount += (n1 - i);
                times[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            times[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            times[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of response time records:");
        int n = sc.nextInt();

        int[] times = new int[n];

        System.out.println("Enter response times:");
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        countViolations(times, 0, n - 1);

        System.out.println("Total performance violations: " + violationCount);

        sc.close();
    }
}