import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks of student " + (i + 1) + ": ");
            physics[i] = sc.nextDouble();
            if (physics[i] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter chemistry marks of student " + (i + 1) + ": ");
            chemistry[i] = sc.nextDouble();
            if (chemistry[i] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter maths marks of student " + (i + 1) + ": ");
            maths[i] = sc.nextDouble();
            if (maths[i] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;

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
                    (i + 1), physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }
        sc.close();
    }
}