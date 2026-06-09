import java.util.Scanner;
public class TotalPurchasePrice {
    public static void main(String[] args) {
        System.out.println("Enter Unit Price:");
        Scanner sc = new Scanner(System.in);
        double unitPrice = sc.nextDouble();
        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.printf("The total purchase price is INR %.2f if the quantity %d and unit price is INR %.2f", totalPrice, quantity, unitPrice);
    }
}