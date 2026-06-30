public class Truck extends Vehicle {
    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 400.0;
    }
}