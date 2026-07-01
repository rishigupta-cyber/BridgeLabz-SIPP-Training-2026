import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
    private ArrayList<T> items = new ArrayList<>();
    private String storageName;

    Storage(String storageName) {
        this.storageName = storageName;
    }

    void addItem(T item) {
        items.add(item);
        System.out.println(item.itemName + " added to " + storageName);
    }

    void removeItem(int index) {
        WarehouseItem removed = items.remove(index);
        System.out.println(removed.itemName + " removed from " + storageName);
    }

    T getItem(int index) {
        return items.get(index);
    }

    List<T> getAllItems() {
        return items;
    }

    int totalItems() {
        return items.size();
    }
}