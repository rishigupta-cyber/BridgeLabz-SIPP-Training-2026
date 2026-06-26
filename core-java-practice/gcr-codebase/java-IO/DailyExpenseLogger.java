import java.io.*;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Daily Expense Logger =====");
        System.out.print("How many expenses to add? ");
        int count = sc.nextInt();
        sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("expenses.txt", true))) {
            for (int i = 0; i < count; i++) {
                System.out.print("Enter category (e.g. Food, Travel): ");
                String category = sc.nextLine().trim();

                System.out.print("Enter amount: ");
                String amountStr = sc.nextLine().trim();

                try {
                    double amount = Double.parseDouble(amountStr);
                    String entry  = category + " - " + (int) amount;
                    bw.write(entry);
                    bw.newLine();
                    System.out.println("Saved: " + entry);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount entered. Skipping this entry.");
                }
            }

            System.out.println("\nAll expenses appended to expenses.txt successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Display current file contents
        System.out.println("\n===== Current Expenses in File =====");
        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("expenses.txt not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}