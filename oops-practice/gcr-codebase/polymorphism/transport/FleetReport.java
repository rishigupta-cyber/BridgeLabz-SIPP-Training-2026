public class FleetReport {

    static void generateReport(Vehicle[] fleet, double km) {
        double totalFuelCost = 0.0;
        int carCount = 0;
        int busCount = 0;
        int bikeCount = 0;
        int electricCarCount = 0;

        for (Vehicle v : fleet) {
            totalFuelCost += v.fuelCost(km);

            if (v instanceof ElectricCar) {
                electricCarCount++;
            } else if (v instanceof Car) {
                carCount++;
            } else if (v instanceof Bus) {
                busCount++;
            } else if (v instanceof Bike) {
                bikeCount++;
            }
        }

        System.out.println("\n--- Fleet Report ---");
        System.out.println("Total vehicles in fleet: " + fleet.length);
        System.out.println("Cars: " + carCount + " | Buses: " + busCount + " | Bikes: " + bikeCount + " | ElectricCars: " + electricCarCount);
        System.out.println("Distance considered: " + km + " km");
        System.out.println("Total fuel cost for entire fleet: Rs." + totalFuelCost);
        System.out.println("Average fuel cost per vehicle: Rs." + (totalFuelCost / fleet.length));
    }
}