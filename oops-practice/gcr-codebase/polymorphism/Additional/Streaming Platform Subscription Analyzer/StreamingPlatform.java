public class StreamingPlatform {

    public static void main(String[] args) {
        Subscription[] subscriptions = new Subscription[6];
        subscriptions[0] = new BasicPlan("Rohit Sharma", "SUB101");
        subscriptions[1] = new PremiumPlan("Neha Kulkarni", "SUB102");
        subscriptions[2] = new FamilyPlan("Vikram Singh", "SUB103");
        subscriptions[3] = new BasicPlan("Anita Desai", "SUB104");
        subscriptions[4] = new PremiumPlan("Rajesh Kumar", "SUB105");
        subscriptions[5] = new FamilyPlan("Riya Mehta", "SUB106");

        System.out.println("--- Monthly Charges ---");
        for (Subscription s : subscriptions) {
            System.out.println(s.subscriberName + " (ID: " + s.subscriptionId + ") - Rs." + s.calculateMonthlyCharge());
        }

        System.out.println();
        String searchId = "SUB103";
        Subscription found = SubscriptionAnalyzer.searchById(subscriptions, searchId);
        if (found != null) {
            System.out.println("Subscription found: " + found.subscriberName + " (" + found.subscriptionId + "), Charge: Rs." + found.calculateMonthlyCharge());
        } else {
            System.out.println("Subscription " + searchId + " not found");
        }

        System.out.println();
        SubscriptionAnalyzer.displaySubscribersByLetter(subscriptions, 'R');

        double totalRevenue = SubscriptionAnalyzer.calculateTotalRevenue(subscriptions);
        System.out.println("\nTotal monthly revenue: Rs." + totalRevenue);

        Subscription mostExpensive = SubscriptionAnalyzer.findMostExpensive(subscriptions);
        System.out.println("Most expensive subscription: " + mostExpensive.subscriberName + " (" + mostExpensive.subscriptionId + "), Rs." + mostExpensive.calculateMonthlyCharge());
    }
}