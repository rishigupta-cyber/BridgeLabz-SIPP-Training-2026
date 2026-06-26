import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter skill scores: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target score: ");
        int target = sc.nextInt();

        findTeams(arr, 0, target, new ArrayList<>());
    }

    static void findTeams(int[] arr, int index, int target, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (index == arr.length || target < 0) {
            return;
        }

        current.add(arr[index]);
        findTeams(arr, index + 1, target - arr[index], current);
        current.remove(current.size() - 1);

        findTeams(arr, index + 1, target, current);
    }
}