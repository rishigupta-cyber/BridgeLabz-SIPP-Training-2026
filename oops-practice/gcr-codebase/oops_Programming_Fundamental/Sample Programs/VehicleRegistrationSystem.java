public class VehicleRegistrationSystem {
    final String registrationNumber;
    String ownerName;
    String vehicleType;
    static double registrationFee = 1500.0;

    VehicleRegistrationSystem(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    void displayDetails(Object obj) {
        if (obj instanceof VehicleRegistrationSystem) {
            System.out.println("Owner: " + ownerName + ", Vehicle: " + vehicleType + ", Reg No: " + registrationNumber + ", Fee: Rs." + registrationFee);
        }
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        VehicleRegistrationSystem v1 = new VehicleRegistrationSystem("Rajesh Kumar", "Car", "MH12AB1234");
        VehicleRegistrationSystem v2 = new VehicleRegistrationSystem("Pooja Iyer", "Bike", "MH14CD5678");

        v1.displayDetails(v1);
        v2.displayDetails(v2);

        VehicleRegistrationSystem.updateRegistrationFee(2000.0);

        System.out.println("After fee update:");
        v1.displayDetails(v1);
        v2.displayDetails(v2);
    }
}