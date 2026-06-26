import java.io.*;

public class GroceryBillReader {
    public static void main(String[] args) {

        // Create sample bill.txt for demo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bill.txt"))) {
            bw.write("Milk       - Rs.60");   bw.newLine();
            bw.write("Bread      - Rs.40");   bw.newLine();
            bw.write("Eggs       - Rs.90");   bw.newLine();
            bw.write("Butter     - Rs.120");  bw.newLine();
            bw.write("Rice (1kg) - Rs.75");   bw.newLine();
        } catch (IOException e) {
            System.out.println("Could not create bill.txt: " + e.getMessage());
            return;
        }

        System.out.println("===== Grocery Bill =====");

        int totalLines = 0;

        try (
            FileReader fr   = new FileReader("bill.txt");
            BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                System.out.println("Line " + totalLines + ": " + line);
            }

            System.out.println("========================");
            System.out.println("Total items in bill: " + totalLines);

        } catch (FileNotFoundException e) {
            System.out.println("Error: bill.txt not found. Please ensure the file exists.");
        } catch (IOException e) {
            System.out.println("Error reading bill.txt: " + e.getMessage());
        }
    }
}