interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Activity data has been reset to zero");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    String deviceId;
    int stepsWalked;

    FitnessDevice(String deviceId, int stepsWalked) {
        this.deviceId = deviceId;
        this.stepsWalked = stepsWalked;
    }

    public void logActivity() {
        System.out.println(deviceId + " logged activity: " + stepsWalked + " steps walked");
    }

    public void generateReport() {
        System.out.println(deviceId + " report: Total steps today - " + stepsWalked);
    }

    public void sendAlert() {
        if (stepsWalked < 2000) {
            System.out.println(deviceId + " alert: You are way behind your daily step goal!");
        } else {
            System.out.println(deviceId + " alert: Good progress on your step goal");
        }
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice("FIT-2001", 1500);

        device.logActivity();
        device.generateReport();
        device.sendAlert();

        device.resetData();
        device.generateReport();

        System.out.println("\nA single class cannot extend multiple classes in Java,");
        System.out.println("but FitnessDevice implements Trackable, Reportable, and Notifiable together -");
        System.out.println("proving multiple inheritance of behavior is possible through interfaces.");
    }
}