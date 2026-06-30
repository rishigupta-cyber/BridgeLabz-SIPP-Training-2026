public class Drone {
    String droneId;
    double batteryPercentage;
    static String companyName = "SkyFast Logistics";

    Drone(String droneId, double batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    void startDelivery() {
        if (batteryPercentage >= 20.0) {
            batteryPercentage -= 15.0;
            System.out.println(droneId + " started delivery. Battery remaining: " + batteryPercentage + "%");
        } else {
            System.out.println(droneId + " cannot start delivery - low battery");
        }
    }

    void displayStatus() {
        System.out.println("Company: " + companyName + " | Drone ID: " + droneId + " | Battery: " + batteryPercentage + "%");
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("DRN-01", 80.0);
        Drone d2 = new Drone("DRN-02", 50.0);
        Drone d3 = new Drone("DRN-03", 15.0);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}