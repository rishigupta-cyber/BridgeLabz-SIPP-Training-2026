public class WaterBottle {
    String ownerName;
    double dailyTarget;

    WaterBottle(String ownerName, double dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    void displayBottleInfo() {
        System.out.println("Owner: " + ownerName + " | Daily Target: " + dailyTarget + " liters");
    }

    public static void main(String[] args) {
        WaterBottle bottle1 = new WaterBottle("Rohit Sharma", 2.5);
        WaterBottle bottle2 = new WaterBottle("Neha Kulkarni", 3.0);

        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}