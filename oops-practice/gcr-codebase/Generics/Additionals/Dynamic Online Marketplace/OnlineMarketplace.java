import java.util.ArrayList;
import java.util.List;

public class OnlineMarketplace {

    static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discountAmount = product.price * percentage / 100;
        product.price = product.price - discountAmount;
        System.out.println("Discount of " + percentage + "% applied on " + product.productName + " | New price: Rs." + product.price);
    }

    static void displayCatalog(List<? extends Product<?>> catalog) {
        System.out.println("--- Product Catalog ---");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        Product<BookCategory> book1 = new Product<>("Clean Code", 499.0, new BookCategory());
        Product<BookCategory> book2 = new Product<>("Effective Java", 799.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 999.0, new ClothingCategory());
        Product<GadgetCategory> earphones = new Product<>("Wireless Earphones", 2499.0, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(shirt);
        catalog.add(earphones);

        displayCatalog(catalog);

        System.out.println();
        applyDiscount(book1, 10.0);
        applyDiscount(shirt, 20.0);
        applyDiscount(earphones, 15.0);

        System.out.println();
        displayCatalog(catalog);
    }
}