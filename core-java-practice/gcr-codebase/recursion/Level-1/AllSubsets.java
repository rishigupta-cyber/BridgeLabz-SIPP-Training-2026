import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        generateSubsets(arr, 0, new ArrayList<>());
    }

    static void generateSubsets(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        generateSubsets(arr, index + 1, current);
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current);
        current.remove(current.size() - 1);
    }
}