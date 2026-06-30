public class Bus extends Vehicle {
    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 250.0;
    }
}