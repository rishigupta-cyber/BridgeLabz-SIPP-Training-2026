import java.util.Scanner;

public class QuickSortFlightTicketPrices {

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Element:");
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(prices[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }
}