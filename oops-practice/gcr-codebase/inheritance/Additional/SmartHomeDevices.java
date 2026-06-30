public class SmartHomeDevices {

    static class Device {
        String deviceId;
        String status;

        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId + " | Status: " + status);
        }
    }

    static class Thermostat extends Device {
        double temperatureSetting;

        Thermostat(String deviceId, String status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId + " | Status: " + status + " | Temperature Setting: " + temperatureSetting + "°C");
        }
    }

    public static void main(String[] args) {
        Device device1 = new Device("DEV-101", "ON");
        Thermostat thermo1 = new Thermostat("DEV-102", "ON", 24.5);

        device1.displayStatus();
        thermo1.displayStatus();
    }
}