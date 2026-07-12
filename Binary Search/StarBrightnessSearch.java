import java.util.Scanner;

public class StarBrightnessSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] catalog = {10, 20, 20, 30, 40, 50, 50, 60, 70, 80};

        System.out.print("Enter target brightness to search: ");
        int target = sc.nextInt();

        int normalResult = binarySearch(catalog, target);
        if (normalResult != -1)
            System.out.println("Target " + target + " found at index: " + normalResult);
        else
            System.out.println("Target " + target + " not found in catalog.");

        int[] rotatedCatalog = {40, 50, 60, 70, 80, 10, 20, 30};
        System.out.print("\nEnter target brightness for rotated catalog: ");
        int rotatedTarget = sc.nextInt();

        int rotatedResult = searchRotated(rotatedCatalog, rotatedTarget);
        if (rotatedResult != -1)
            System.out.println("Target " + rotatedTarget + " found at index: " + rotatedResult + " in rotated catalog.");
        else
            System.out.println("Target " + rotatedTarget + " not found in rotated catalog.");

        System.out.print("\nEnter brightness value to find first and last occurrence: ");
        int occTarget = sc.nextInt();

        int first = findFirst(catalog, occTarget);
        int last = findLast(catalog, occTarget);

        if (first == -1)
            System.out.println("Target " + occTarget + " not found.");
        else
            System.out.println("First occurrence: " + first + ", Last occurrence: " + last);

        int minIndex = findMinimum(catalog);
        System.out.println("\nMinimum element in catalog: " + catalog[minIndex] + " at index: " + minIndex);

        sc.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int searchRotated(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return result;
    }

    public static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}