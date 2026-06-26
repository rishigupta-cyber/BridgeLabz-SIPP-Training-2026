import java.util.Scanner;


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        double[] patientBills = {1200.50, 2500.00, 0.0, 800.75}; 
        int patientCount = patientBills.length;

        try {
            System.out.print("Enter patient index (0-" + (patientCount-1) + "): ");
            int index = Integer.parseInt(sc.nextLine()); 

            
            double bill = patientBills[index]; 


            System.out.print("Enter number of items in bill: ");
            int items = Integer.parseInt(sc.nextLine());
            double avgCost = bill / items; 

            System.out.println("Patient bill: " + bill);
            System.out.println("Average cost per item: " + avgCost);

            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());
            processPayment(bill, payment);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid patient index! Please enter between 0 and " + (patientCount-1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero (no items in bill).");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Billing operation completed safely.");
        }
    }
    public static void processPayment(double bill, double payment) throws InsufficientFundsException {
        if (payment < bill) {
            throw new InsufficientFundsException("Payment failed: Insufficient balance!");
        } else {
            System.out.println("Payment successful. Change returned: " + (payment - bill));
        }
    }
}