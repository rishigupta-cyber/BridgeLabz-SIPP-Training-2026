import java.util.Scanner;

public class HospitalEmergencyKthPriority {

    public static int partition(int[] priorities, int low, int high) {
        int pivot = priorities[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (priorities[j] > pivot) {
                i++;
                int temp = priorities[i];
                priorities[i] = priorities[j];
                priorities[j] = temp;
            }
        }

        int temp = priorities[i + 1];
        priorities[i + 1] = priorities[high];
        priorities[high] = temp;

        return i + 1;
    }

    public static int quickSelect(int[] priorities, int low, int high, int k) {
        if (low == high) {
            return priorities[low];
        }

        int pivotIndex = partition(priorities, low, high);
        int rank = pivotIndex - low + 1;

        if (rank == k) {
            return priorities[pivotIndex];
        } else if (k < rank) {
            return quickSelect(priorities, low, pivotIndex - 1, k);
        } else {
            return quickSelect(priorities, pivotIndex + 1, high, k - rank);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of patients:");
        int n = sc.nextInt();

        int[] priorities = new int[n];

        System.out.println("Enter emergency priorities of patients:");
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        System.out.println("Enter value of k:");
        int k = sc.nextInt();

        int result = quickSelect(priorities, 0, n - 1, k);

        System.out.println("Patient with " + k + " highest priority: " + result);

        sc.close();
    }
}