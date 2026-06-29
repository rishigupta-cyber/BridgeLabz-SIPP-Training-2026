public class ShoppingCartSystem {
    final String productID;
    String productName;
    double price;
    int quantity;
    static double discount = 10.0;

    ShoppingCartSystem(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void displayDetails(Object obj) {
        if (obj instanceof ShoppingCartSystem) {
            double finalPrice = price - (price * discount / 100);
            System.out.println("Product: " + productName + ", ID: " + productID + ", Qty: " + quantity + ", Price after discount: Rs." + finalPrice);
        }
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public static void main(String[] args) {
        ShoppingCartSystem p1 = new ShoppingCartSystem("P501", "Wireless Mouse", 800.0, 2);
        ShoppingCartSystem p2 = new ShoppingCartSystem("P502", "Mechanical Keyboard", 3500.0, 1);

        p1.displayDetails(p1);
        p2.displayDetails(p2);

        ShoppingCartSystem.updateDiscount(15.0);

        System.out.println("After discount update:");
        p1.displayDetails(p1);
        p2.displayDetails(p2);
    }
}