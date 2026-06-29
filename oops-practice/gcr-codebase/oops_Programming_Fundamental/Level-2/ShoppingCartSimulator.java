import java.util.ArrayList;

public class ShoppingCartSimulator {
    static ArrayList<ShoppingCartSimulator> cart = new ArrayList<>();

    String itemName;
    double price;
    int quantity;

    ShoppingCartSimulator(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addToCart() {
        cart.add(this);
        System.out.println(itemName + " added to cart.");
    }

    void removeFromCart() {
        cart.remove(this);
        System.out.println(itemName + " removed from cart.");
    }

    static void displayTotalCost() {
        double total = 0.0;
        for (ShoppingCartSimulator item : cart) {
            total = total + (item.price * item.quantity);
        }
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        ShoppingCartSimulator item1 = new ShoppingCartSimulator("Notebook", 60.0, 3);
        ShoppingCartSimulator item2 = new ShoppingCartSimulator("Pen", 10.0, 5);
        ShoppingCartSimulator item3 = new ShoppingCartSimulator("Backpack", 1200.0, 1);

        item1.addToCart();
        item2.addToCart();
        item3.addToCart();

        displayTotalCost();

        item2.removeFromCart();

        displayTotalCost();
    }
}