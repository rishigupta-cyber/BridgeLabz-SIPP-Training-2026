public class HeapSortSensor {

    static void siftDownMax(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            siftDownMax(arr, largest, size);
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }
        for (int end = n - 1; end > 0; end--) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            siftDownMax(arr, 0, end);
        }
    }

    public static void main(String[] args) {
        int[] readings = {42, 17, 63, 8, 55, 31, 26};

        System.out.println("Before sort:");
        for (int r : readings) System.out.print(r + " ");

        heapSort(readings);

        System.out.println("\nAfter heap sort:");
        for (int r : readings) System.out.print(r + " ");
    }
}