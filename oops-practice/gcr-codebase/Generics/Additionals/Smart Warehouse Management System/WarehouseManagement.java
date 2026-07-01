import java.util.List;

public class WarehouseManagement {

    static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("--- Warehouse Inventory ---");
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>("Electronics Bay");
        electronicsStorage.addItem(new Electronics("Laptop", 55000.0, "Dell"));
        electronicsStorage.addItem(new Electronics("Wireless Mouse", 800.0, "Logitech"));

        Storage<Groceries> groceriesStorage = new Storage<>("Grocery Bay");
        groceriesStorage.addItem(new Groceries("Basmati Rice", 120.0, "2026-12-01"));
        groceriesStorage.addItem(new Groceries("Olive Oil", 450.0, "2027-06-01"));

        Storage<Furniture> furnitureStorage = new Storage<>("Furniture Bay");
        furnitureStorage.addItem(new Furniture("Office Chair", 8500.0, "Wood"));
        furnitureStorage.addItem(new Furniture("Study Table", 12000.0, "MDF"));

        System.out.println();
        displayAllItems(electronicsStorage.getAllItems());
        displayAllItems(groceriesStorage.getAllItems());
        displayAllItems(furnitureStorage.getAllItems());

        System.out.println("\nElectronics count: " + electronicsStorage.totalItems());
        System.out.println("Groceries count: " + groceriesStorage.totalItems());
        System.out.println("Furniture count: " + furnitureStorage.totalItems());
    }
}