public class SMSNotification extends Notification {
    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("[SMS] To: " + recipientName + " | Message: " + message);
    }
}