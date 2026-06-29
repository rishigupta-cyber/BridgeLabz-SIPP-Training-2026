public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1000.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Vehicle: " + vehicleType + ", Registration Fee: Rs." + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Suresh Patil", "Car");
        Vehicle v2 = new Vehicle("Anita Desai", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(1500.0);

        System.out.println("After fee update:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}