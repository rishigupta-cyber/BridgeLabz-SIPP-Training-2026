import java.util.Scanner;

public class MergeSortEmployeeSalaries {

    public static void mergeSort(int[] salaries, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(salaries, left, mid);
            mergeSort(salaries, mid + 1, right);
            merge(salaries, left, mid, right);
        }
    }

    public static void merge(int[] salaries, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = salaries[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = salaries[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                salaries[k] = leftArr[i];
                i++;
            } else {
                salaries[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            salaries[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            salaries[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter size of array:");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] salaries = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the element:");
            salaries[i] = sc.nextInt();
        }

        mergeSort(salaries, 0, n - 1);

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(salaries[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}