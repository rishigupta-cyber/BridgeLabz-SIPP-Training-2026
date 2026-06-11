import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            personData[i][0] = sc.nextDouble();
            if (personData[i][0] <= 0) {
                System.out.println("Invalid value. Please enter a positive value.");
                i--;
                continue;
            }

            System.out.print("Enter height of person " + (i + 1) + " (m): ");
            personData[i][1] = sc.nextDouble();
            if (personData[i][1] <= 0) {
                System.out.println("Invalid value. Please enter a positive value.");
                i--;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson Details:");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d => Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s%n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        System.out.println("------------------------------------------------------------");

        sc.close();
    }
}