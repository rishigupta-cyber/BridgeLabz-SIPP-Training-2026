public class Car extends Vehicle {
    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 100.0;
    }
}