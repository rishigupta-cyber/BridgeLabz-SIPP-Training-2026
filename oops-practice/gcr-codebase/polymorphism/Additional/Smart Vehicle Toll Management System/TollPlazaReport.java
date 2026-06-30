public class TollPlazaReport {

    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            total += v.calculateToll();
        }
        return total;
    }

    static Vehicle searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {
                return v;
            }
        }
        return null;
    }

    static Vehicle findHighestTollPayer(Vehicle[] vehicles) {
        Vehicle highest = vehicles[0];
        for (Vehicle v : vehicles) {
            if (v.calculateToll() > highest.calculateToll()) {
                highest = v;
            }
        }
        return highest;
    }

    static void countVehiclesByType(Vehicle[] vehicles) {
        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                carCount++;
            } else if (v instanceof Bus) {
                busCount++;
            } else if (v instanceof Truck) {
                truckCount++;
            }
        }

        System.out.println("Cars: " + carCount + " | Buses: " + busCount + " | Trucks: " + truckCount);
    }
}