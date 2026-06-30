interface HeartRateMonitor {
    int getHeartRate(String patientId);

    default void displayHealthTips() {
        System.out.println("Heart rate tip: Maintain a balanced diet and exercise regularly to keep heart rate normal");
    }
}

interface TemperatureMonitor {
    double getTemperature(String patientId);

    default void displayHealthTips() {
        System.out.println("Temperature tip: Stay hydrated and rest well if body temperature is elevated");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.startsWith("PT") && patientId.length() == 6;
    }
}

public class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    public int getHeartRate(String patientId) {
        return 60 + (patientId.hashCode() % 40 + 40) % 40;
    }

    public double getTemperature(String patientId) {
        return 97.5 + (patientId.hashCode() % 30) / 10.0;
    }

    public void displayHealthTips() {
        System.out.println("Combined tip: Regular monitoring of heart rate and temperature helps detect issues early");
    }

    public static void main(String[] args) {
        String[] patientNames = {"Sunita Rao", "Arjun Mehta", "Pooja Iyer", "Rajesh Kumar"};
        String[] patientIds = {"PT1001", "PT1002", "PT99", "PT1004"};

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();
        System.out.println();

        System.out.println("--- Health Report ---");
        for (int i = 0; i < patientNames.length; i++) {
            boolean validId = TemperatureMonitor.isPatientIdValid(patientIds[i]);

            if (!validId) {
                System.out.println(patientNames[i] + " (ID: " + patientIds[i] + ") - Invalid patient ID, cannot record readings");
                continue;
            }

            int heartRate = system.getHeartRate(patientIds[i]);
            double temperature = system.getTemperature(patientIds[i]);

            System.out.println(patientNames[i] + " (ID: " + patientIds[i] + ") - Heart Rate: " + heartRate + " bpm, Temperature: " + temperature + " F");
        }
    }
}