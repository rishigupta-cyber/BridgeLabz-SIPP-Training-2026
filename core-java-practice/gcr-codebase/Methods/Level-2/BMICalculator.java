import java.util.Scanner;

public class BMICalculator {

    public static double[][] calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100;
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi;
        }
        return data;
    }

    public static String[] findBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];

        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height in cm for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        data = calculateBMI(data);
        String[] status = findBMIStatus(data);

        System.out.println("\nResults:");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Person " + (i + 1) + " - Height: " + data[i][1] + " cm, Weight: "
                    + data[i][0] + " kg, BMI: " + data[i][2] + ", Status: " + status[i]);
        }

        sc.close();
    }
}