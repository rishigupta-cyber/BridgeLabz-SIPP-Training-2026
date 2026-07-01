public class Electronics extends WarehouseItem {
    String brand;

    Electronics(String itemName, double price, String brand) {
        super(itemName, price);
        this.brand = brand;
    }

    public String getCategory() {
        return "Electronics";
    }

    public String toString() {
        return super.toString() + " | Brand: " + brand;
    }
}