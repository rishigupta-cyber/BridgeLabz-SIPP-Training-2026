public class Furniture extends WarehouseItem {
    String material;

    Furniture(String itemName, double price, String material) {
        super(itemName, price);
        this.material = material;
    }

    public String getCategory() {
        return "Furniture";
    }

    public String toString() {
        return super.toString() + " | Material: " + material;
    }
}