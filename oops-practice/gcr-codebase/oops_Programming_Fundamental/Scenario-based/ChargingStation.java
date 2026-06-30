public class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 8.5;

    String stationId;
    double unitsConsumed;

    ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station: " + stationId + " | Units consumed: " + unitsConsumed + " | Bill: Rs." + calculateBill());
    }

    static void updateRate(double newRate) {
        electricityRate = newRate;
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation("CS-01", 120.0);
        ChargingStation s2 = new ChargingStation("CS-02", 95.0);
        ChargingStation s3 = new ChargingStation("CS-03", 60.0);
        ChargingStation s4 = new ChargingStation("CS-04", 150.0);
        ChargingStation s5 = new ChargingStation("CS-05", 80.0);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total stations: " + totalStations);

        ChargingStation.updateRate(10.0);

        System.out.println("After electricity rate update:");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}