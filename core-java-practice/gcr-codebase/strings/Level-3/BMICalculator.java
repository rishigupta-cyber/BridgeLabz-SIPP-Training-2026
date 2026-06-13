import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;

        double[][] data = new double[n][2];

        System.out.println("Enter weight (kg) and height (cm) for " + n + " members:");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight for member " + (i + 1) + ":");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height for member " + (i + 1) + ":");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = computeBMIDetails(data);
        displayResult(result);

        sc.close();
    }

    public static String[] computeBMI(double weight, double height) {
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] { String.valueOf(bmi), status };
    }

    public static String[][] computeBMIDetails(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiDetails = computeBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiDetails[0];
            result[i][3] = bmiDetails[1];
        }

        return result;
    }

    public static void displayResult(String[][] result) {
        System.out.println("Height\tWeight\tBMI\tStatus");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
        }
    }
}