import java.util.Scanner;

public class MatrixBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        int left = 0;
        int right = rows * cols - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                found = true;
                System.out.println("Target " + target + " found at row " + row + ", column " + col);
                break;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found)
            System.out.println("Target " + target + " not found in the matrix.");

        sc.close();
    }
}