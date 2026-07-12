public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] scores = {67, 88, 45, 90, 72, 59};

        System.out.println("Scores before sorting:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("Scores after sorting:");
        printArray(scores);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}