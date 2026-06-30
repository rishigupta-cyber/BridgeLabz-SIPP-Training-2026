public class PushNotification extends Notification {
    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("[Push] To: " + recipientName + " | Message: " + message);
    }
}