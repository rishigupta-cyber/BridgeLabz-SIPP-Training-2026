import java.util.Scanner;

public class BubbleSortStudentMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 45, 92, 63, 55, 89, 30};

        System.out.println("Marks before sorting:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("Marks after sorting:");
        printArray(marks);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}