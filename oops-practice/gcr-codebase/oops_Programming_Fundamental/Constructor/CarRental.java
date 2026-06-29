public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay = 1500.0;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double totalCost() {
        return rentalDays * ratePerDay;
    }

    void display() {
        System.out.println(customerName + " rented " + carModel + " for " + rentalDays + " days");
        System.out.println("Total cost: Rs." + totalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Vikram Singh", "Hyundai Creta", 4);
        rental1.display();
    }
}