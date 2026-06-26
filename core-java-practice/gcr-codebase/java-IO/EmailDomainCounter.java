import java.io.*;
import java.util.*;

public class EmailDomainCounter {
    public static void main(String[] args) {

        // Create sample emails.txt for demo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("emails.txt"))) {
            bw.write("rahul@gmail.com");   bw.newLine();
            bw.write("ankit@yahoo.com");   bw.newLine();
            bw.write("priya@gmail.com");   bw.newLine();
            bw.write("sneha@outlook.com"); bw.newLine();
            bw.write("amit@yahoo.com");    bw.newLine();
            bw.write("pooja@gmail.com");   bw.newLine();
            bw.write("raj@outlook.com");   bw.newLine();
        } catch (IOException e) {
            System.out.println("Could not create emails.txt: " + e.getMessage());
            return;
        }

        String[] domains  = new String[100];
        int[]    counts   = new int[100];
        int      uniqueCount = 0;

        System.out.println("===== Reading Emails =====");

        try (BufferedReader br = new BufferedReader(new FileReader("emails.txt"))) {
            String email;

            while ((email = br.readLine()) != null) {
                email = email.trim();
                if (email.isEmpty() || !email.contains("@")) continue;

                System.out.println("Email: " + email);

                int    atIndex = email.indexOf("@");
                String domain  = email.substring(atIndex + 1).toLowerCase();

                boolean found = false;
                for (int i = 0; i < uniqueCount; i++) {
                    if (domains[i].equals(domain)) {
                        counts[i]++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    domains[uniqueCount] = domain;
                    counts[uniqueCount]  = 1;
                    uniqueCount++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: emails.txt not found.");
            return;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("\n===== Email Domain Summary =====");
        for (int i = 0; i < uniqueCount; i++) {
            String label = domains[i].substring(0, domains[i].indexOf("."));
            label = Character.toUpperCase(label.charAt(0)) + label.substring(1);
            System.out.println(label + " users : " + counts[i]);
        }
    }
}