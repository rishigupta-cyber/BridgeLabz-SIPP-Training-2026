import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    static void generateReportCard() {
        String inputFile  = "students.txt";
        String outputFile = "reportcard.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw     = new FileWriter(outputFile, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("========================================");
            bw.newLine();
            bw.write("           STUDENT REPORT CARD          ");
            bw.newLine();
            bw.write("========================================");
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name    = parts[0].trim();

                double total = 0;
                int count    = parts.length - 1;

                for (int i = 1; i < parts.length; i++) {
                    total += Double.parseDouble(parts[i].trim());
                }

                double average = total / count;
                String grade;

                if      (average >= 90) grade = "A+";
                else if (average >= 80) grade = "A";
                else if (average >= 70) grade = "B";
                else if (average >= 60) grade = "C";
                else                    grade = "F";

                String report = String.format("%-15s | Average: %6.2f | Grade: %s", name, average, grade);
                bw.write(report);
                bw.newLine();

                System.out.println(report);
            }

            bw.write("========================================");
            bw.newLine();
            System.out.println("Report card saved to: " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" + inputFile + "' not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid marks format in file. Please check the data.");
        }
    }

    public static void main(String[] args) {

        // Create sample students.txt for demo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
            bw.write("Alice, 88, 92, 76, 95, 89");  bw.newLine();
            bw.write("Bob, 70, 65, 80, 75, 60");     bw.newLine();
            bw.write("Charlie, 95, 98, 100, 92, 97");bw.newLine();
            bw.write("Diana, 55, 60, 50, 45, 58");   bw.newLine();
        } catch (IOException e) {
            System.out.println("Could not create sample file: " + e.getMessage());
        }

        generateReportCard();
    }
}