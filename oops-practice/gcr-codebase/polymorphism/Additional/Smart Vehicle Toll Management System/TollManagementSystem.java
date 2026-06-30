public class TollManagementSystem {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Car("MH12AB1234", "Rohit Sharma");
        vehicles[1] = new Bus("MH14CD5678", "Neha Kulkarni");
        vehicles[2] = new Truck("MH16EF9012", "Vikram Singh");
        vehicles[3] = new Car("MH18GH3456", "Anita Desai");
        vehicles[4] = new Truck("MH20IJ7890", "Suresh Patil");
        vehicles[5] = new Bus("MH22KL2345", "Pooja Iyer");

        System.out.println("--- Toll Charges ---");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleNumber + " (" + v.ownerName + ") - Toll: Rs." + v.calculateToll());
        }

        double totalRevenue = TollPlazaReport.calculateTotalRevenue(vehicles);
        System.out.println("\nTotal toll revenue collected: Rs." + totalRevenue);

        String searchNumber = "MH16EF9012";
        Vehicle found = TollPlazaReport.searchVehicle(vehicles, searchNumber);
        if (found != null) {
            System.out.println("\nVehicle found: " + found.vehicleNumber + " (" + found.ownerName + "), Toll: Rs." + found.calculateToll());
        } else {
            System.out.println("\nVehicle " + searchNumber + " not found");
        }

        Vehicle highestPayer = TollPlazaReport.findHighestTollPayer(vehicles);
        System.out.println("\nHighest toll paid by: " + highestPayer.vehicleNumber + " (" + highestPayer.ownerName + "), Toll: Rs." + highestPayer.calculateToll());

        System.out.println("\n--- Vehicle Count by Type ---");
        TollPlazaReport.countVehiclesByType(vehicles);
    }
}