public class SmartNotificationSystem {

    public static void main(String[] args) {
        Notification[] notifications = new Notification[4];

        notifications[0] = new EmailNotification("Rohit Sharma", "Your order has been shipped");
        notifications[1] = new SMSNotification("Neha Kulkarni", "OTP for login is 4567");
        notifications[2] = new PushNotification("Vikram Singh", "You have a new message");
        notifications[3] = new EmailNotification("Anita Desai", "Your invoice is ready");

        System.out.println("--- Sending All Notifications ---");
        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}