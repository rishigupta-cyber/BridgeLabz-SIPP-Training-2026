public class PremiumPlan extends Subscription {
    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 499.0;
    }
}