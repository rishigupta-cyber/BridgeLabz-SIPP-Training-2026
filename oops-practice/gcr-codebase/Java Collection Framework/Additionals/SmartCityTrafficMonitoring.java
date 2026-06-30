import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoring {
    static HashMap<String, Integer> roadTraffic = new HashMap<>();

    static void recordVehicle(String roadName, int count) {
        roadTraffic.merge(roadName, count, Integer::sum);
        System.out.println(count + " vehicles recorded on " + roadName);
    }

    static void displaySortedByRoadName() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(roadTraffic);
        System.out.println("--- Roads (sorted by name) ---");
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " vehicles");
        }
    }

    static void findBusiestRoad() {
        String busiestRoad = null;
        int maxVehicles = -1;

        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }

        System.out.println("Busiest road: " + busiestRoad + " with " + maxVehicles + " vehicles");
    }

    static void generateTrafficReport() {
        System.out.println("--- Traffic Analysis Report ---");
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            String status;
            if (entry.getValue() > 500) {
                status = "Heavy Traffic";
            } else if (entry.getValue() > 200) {
                status = "Moderate Traffic";
            } else {
                status = "Light Traffic";
            }
            System.out.println(entry.getKey() + " - " + entry.getValue() + " vehicles - " + status);
        }
        System.out.println("Total roads monitored: " + roadTraffic.size());
    }

    public static void main(String[] args) {
        recordVehicle("MG Road", 350);
        recordVehicle("FC Road", 620);
        recordVehicle("Sinhagad Road", 180);
        recordVehicle("Karve Road", 480);
        recordVehicle("FC Road", 100);

        System.out.println();
        displaySortedByRoadName();

        System.out.println();
        findBusiestRoad();

        System.out.println();
        generateTrafficReport();
    }
}