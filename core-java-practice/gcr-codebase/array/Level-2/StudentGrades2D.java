import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks of student " + (i + 1) + ": ");
            marks[i][0] = sc.nextDouble();
            if (marks[i][0] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter chemistry marks of student " + (i + 1) + ": ");
            marks[i][1] = sc.nextDouble();
            if (marks[i][1] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter maths marks of student " + (i + 1) + ": ");
            marks[i][2] = sc.nextDouble();
            if (marks[i][2] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

            if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "R";
            }
        }

        System.out.println("\nStudent Details:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d => Physics: %.1f, Chemistry: %.1f, Maths: %.1f, Percentage: %.2f%%, Grade: %s%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }
}