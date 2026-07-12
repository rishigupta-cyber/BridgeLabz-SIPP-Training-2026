import java.util.Scanner;

public class MergeSortCustomerOrderValues {

    public static void mergeSort(int[] orders, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);
            merge(orders, left, mid, right);
        }
    }

    public static void merge(int[] orders, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = orders[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = orders[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                orders[k] = leftArr[i];
                i++;
            } else {
                orders[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            orders[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            orders[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] orders = new int[n];

        for (int i = 0; i < n; i++) {
            orders[i] = sc.nextInt();
        }

        mergeSort(orders, 0, n - 1);

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(orders[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}