import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int peakIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean leftSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                peakIndex = mid;
                break;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Peak element is: " + arr[peakIndex] + " at index: " + peakIndex);

        sc.close();
    }
}