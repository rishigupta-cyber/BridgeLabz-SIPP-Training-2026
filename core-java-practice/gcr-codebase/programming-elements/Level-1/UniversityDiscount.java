public class UniversityDiscount {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        double discount = (discountPercent / 100.0) * fee;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.1f and final discounted fee is INR %.1f", discount, finalFee);
    }
}