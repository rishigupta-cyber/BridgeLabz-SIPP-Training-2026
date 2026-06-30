public class EmailNotification extends Notification {
    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("[Email] To: " + recipientName + " | Message: " + message);
    }
}