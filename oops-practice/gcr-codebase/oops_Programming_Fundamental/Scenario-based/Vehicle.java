public class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(Vehicle[] vehicles) {
        System.out.println("--- Cars ---");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " | Owner: " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("--- Bikes ---");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " | Owner: " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("MH12AB1234", "Rohit Sharma", "Car");
        vehicles[1] = new Vehicle("MH14CD5678", "Neha Kulkarni", "Bike");
        vehicles[2] = new Vehicle("MH16EF9012", "Vikram Singh", "Car");
        vehicles[3] = new Vehicle("MH18GH3456", "Anita Desai", "Bike");
        vehicles[4] = new Vehicle("MH20IJ7890", "Suresh Patil", "Car");
        vehicles[5] = new Vehicle("MH22KL2345", "Pooja Iyer", "Bike");
        vehicles[6] = new Vehicle("MH24MN6789", "Arjun Mehta", "Car");
        vehicles[7] = new Vehicle("MH26OP3456", "Sunita Rao", "Bike");
        vehicles[8] = new Vehicle("MH28QR7890", "Rajesh Kumar", "Car");
        vehicles[9] = new Vehicle("MH30ST1234", "Meena Shah", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}