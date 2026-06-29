public class MobilePhoneDetails {
    String brand;
    String model;
    double price;

    MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhoneDetails phone1 = new MobilePhoneDetails("Samsung", "Galaxy S24", 74999.0);
        MobilePhoneDetails phone2 = new MobilePhoneDetails("Apple", "iPhone 15", 79999.0);

        phone1.displayDetails();
        System.out.println();
        phone2.displayDetails();
    }
}