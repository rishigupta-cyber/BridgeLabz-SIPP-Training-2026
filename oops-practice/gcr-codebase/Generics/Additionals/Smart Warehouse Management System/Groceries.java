public class Groceries extends WarehouseItem {
    String expiryDate;

    Groceries(String itemName, double price, String expiryDate) {
        super(itemName, price);
        this.expiryDate = expiryDate;
    }

    public String getCategory() {
        return "Groceries";
    }

    public String toString() {
        return super.toString() + " | Expiry: " + expiryDate;
    }
}