public class SubscriptionAnalyzer {

    static Subscription searchById(Subscription[] subscriptions, String subscriptionId) {
        for (Subscription s : subscriptions) {
            if (s.subscriptionId.equalsIgnoreCase(subscriptionId)) {
                return s;
            }
        }
        return null;
    }

    static void displaySubscribersByLetter(Subscription[] subscriptions, char letter) {
        System.out.println("Subscribers starting with '" + letter + "':");
        for (Subscription s : subscriptions) {
            if (Character.toUpperCase(s.subscriberName.charAt(0)) == Character.toUpperCase(letter)) {
                System.out.println(s.subscriberName + " (ID: " + s.subscriptionId + ")");
            }
        }
    }

    static double calculateTotalRevenue(Subscription[] subscriptions) {
        double total = 0.0;
        for (Subscription s : subscriptions) {
            total += s.calculateMonthlyCharge();
        }
        return total;
    }

    static Subscription findMostExpensive(Subscription[] subscriptions) {
        Subscription mostExpensive = subscriptions[0];
        for (Subscription s : subscriptions) {
            if (s.calculateMonthlyCharge() > mostExpensive.calculateMonthlyCharge()) {
                mostExpensive = s;
            }
        }
        return mostExpensive;
    }
}