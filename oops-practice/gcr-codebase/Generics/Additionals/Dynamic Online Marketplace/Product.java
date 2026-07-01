public class Product<T extends Category> {
    String productName;
    double price;
    T category;

    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return "Product: " + productName + " | Price: Rs." + price + " | Category: " + category;
    }
}