public class HeapifyBatch {

    static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest]) smallest = left;
        if (right < size && arr[right] < arr[smallest]) smallest = right;

        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            siftDown(arr, smallest, size);
        }
    }

    static void buildHeap(int[] priorities) {
        int n = priorities.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    public static void main(String[] args) {
        int[] priorities = {15, 3, 22, 7, 1, 18, 4};

        System.out.println("Before heapify:");
        for (int p : priorities) System.out.print(p + " ");

        buildHeap(priorities);

        System.out.println("\nAfter heapify (min-heap):");
        for (int p : priorities) System.out.print(p + " ");
        System.out.println("\nRoot (min priority): " + priorities[0]);
    }
}