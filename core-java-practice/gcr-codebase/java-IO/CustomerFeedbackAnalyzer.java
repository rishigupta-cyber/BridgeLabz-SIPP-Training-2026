import java.io.*;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {

        // Create sample feedback.txt for demo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("feedback.txt"))) {
            bw.write("Good service");    bw.newLine();
            bw.write("delivery was good"); bw.newLine();
            bw.write("average");         bw.newLine();
            bw.write("good packaging");  bw.newLine();
            bw.write("late delivery");   bw.newLine();
        } catch (IOException e) {
            System.out.println("Could not create feedback file: " + e.getMessage());
            return;
        }

        int goodCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null && lineNumber < 5) {
                System.out.println("Feedback " + (lineNumber + 1) + ": " + line);
                if (line.trim().toLowerCase().contains("good")) {
                    goodCount++;
                }
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: feedback.txt not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("\nGood Feedback Count = " + goodCount);
    }
}