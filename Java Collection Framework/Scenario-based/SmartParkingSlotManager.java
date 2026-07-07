import java.util.ArrayList;

public class SmartParkingSlotManager {
    static ArrayList<String> parkedVehicles = new ArrayList<>();

    static void enterParking(String vehicleNumber) {
        if (parkedVehicles.contains(vehicleNumber)) {
            System.out.println(vehicleNumber + " is already parked");
            return;
        }
        parkedVehicles.add(vehicleNumber);
        System.out.println(vehicleNumber + " has entered the parking area");
    }

    static void exitParking(String vehicleNumber) {
        if (parkedVehicles.remove(vehicleNumber)) {
            System.out.println(vehicleNumber + " has exited the parking area");
        } else {
            System.out.println(vehicleNumber + " was not found in the parking area");
        }
    }

    static void searchVehicle(String vehicleNumber) {
        if (parkedVehicles.contains(vehicleNumber)) {
            System.out.println(vehicleNumber + " is currently parked");
        } else {
            System.out.println(vehicleNumber + " is not in the parking area");
        }
    }

    static void displayParkedVehicles() {
        System.out.println("--- Currently Parked Vehicles ---");
        for (String vehicle : parkedVehicles) {
            System.out.println(vehicle);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        enterParking("MH12AB1234");
        enterParking("MH14CD5678");
        enterParking("MH16EF9012");
        enterParking("MH12AB1234");

        System.out.println();
        searchVehicle("MH14CD5678");
        searchVehicle("MH99ZZ0000");

        System.out.println();
        exitParking("MH14CD5678");
        exitParking("MH99ZZ0000");

        System.out.println();
        displayParkedVehicles();
    }
}