public class ItemInventoryTracker {
    int itemCode;
    String itemName;
    double price;

    ItemInventoryTracker(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        ItemInventoryTracker item = new ItemInventoryTracker(501, "Wireless Mouse", 650.0);
        item.displayItemDetails();

        int quantity = 4;
        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Total Cost for " + quantity + " units: " + totalCost);
    }
}