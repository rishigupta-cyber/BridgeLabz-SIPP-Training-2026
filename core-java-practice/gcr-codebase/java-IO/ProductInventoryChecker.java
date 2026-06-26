import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {

        // Create sample inventory.txt for demo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.txt"))) {
            bw.write("Laptop-10");    bw.newLine();
            bw.write("Mouse-0");      bw.newLine();
            bw.write("Keyboard-5");   bw.newLine();
            bw.write("Monitor-0");    bw.newLine();
            bw.write("Headphones-3"); bw.newLine();
            bw.write("Webcam-0");     bw.newLine();
        } catch (IOException e) {
            System.out.println("Could not create inventory.txt: " + e.getMessage());
            return;
        }

        System.out.println("===== Inventory Report =====");

        int outOfStockCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || !line.contains("-")) continue;

                int    dashIndex  = line.lastIndexOf("-");
                String product    = line.substring(0, dashIndex).trim();
                String qtyStr     = line.substring(dashIndex + 1).trim();

                try {
                    int quantity = Integer.parseInt(qtyStr);
                    if (quantity == 0) {
                        System.out.println(product + " is out of stock");
                        outOfStockCount++;
                    } else {
                        System.out.println(product + " is available (Qty: " + quantity + ")");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity for product: " + product);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: inventory.txt not found.");
            return;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("============================");
        System.out.println("Total out-of-stock items: " + outOfStockCount);
    }
}