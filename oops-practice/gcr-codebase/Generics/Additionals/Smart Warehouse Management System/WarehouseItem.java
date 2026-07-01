public abstract class WarehouseItem {
    String itemName;
    double price;

    WarehouseItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    abstract String getCategory();

    public String toString() {
        return "Item: " + itemName + " | Price: Rs." + price + " | Category: " + getCategory();
    }
}