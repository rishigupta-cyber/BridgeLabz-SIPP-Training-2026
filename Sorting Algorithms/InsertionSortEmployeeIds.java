public class InsertionSortEmployeeIds {

    public static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {2031, 1042, 5023, 1899, 3067, 1420};

        System.out.println("Employee IDs before sorting:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("Employee IDs after sorting:");
        printArray(employeeIds);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}