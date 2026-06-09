// Problem 9
import java.util.Scanner;
public class UniversityDiscountInput {
    public static void main(String[] args) {
        System.out.println("Enter fee:");
        Scanner sc = new Scanner(System.in);
        double fee = sc.nextDouble();
        System.out.println("Enter discount percent:");
        double discountPercent = sc.nextDouble();
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.1f and final discounted fee is INR %.1f", discount, finalFee);
    }
}