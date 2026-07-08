import java.util.Scanner;

public class MergeCustomerRecords {

    public static int[] mergeSortedArrays(int[] branchA, int[] branchB) {
        int n1 = branchA.length;
        int n2 = branchB.length;
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (branchA[i] <= branchB[j]) {
                merged[k] = branchA[i];
                i++;
            } else {
                merged[k] = branchB[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            merged[k] = branchA[i];
            i++;
            k++;
        }

        while (j < n2) {
            merged[k] = branchB[j];
            j++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of customer IDs in Branch A:");
        int n1 = sc.nextInt();
        int[] branchA = new int[n1];

        System.out.println("Enter customer IDs of Branch A in ascending order:");
        for (int i = 0; i < n1; i++) {
            branchA[i] = sc.nextInt();
        }

        System.out.println("Enter number of customer IDs in Branch B:");
        int n2 = sc.nextInt();
        int[] branchB = new int[n2];

        System.out.println("Enter customer IDs of Branch B in ascending order:");
        for (int i = 0; i < n2; i++) {
            branchB[i] = sc.nextInt();
        }

        int[] result = mergeSortedArrays(branchA, branchB);

        System.out.print("Merged customer records: ");
        for (int id : result) {
            System.out.print(id + " ");
        }
        System.out.println();

        sc.close();
    }
}