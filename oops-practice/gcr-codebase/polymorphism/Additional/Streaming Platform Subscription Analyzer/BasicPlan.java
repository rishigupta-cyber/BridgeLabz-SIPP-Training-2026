public class BasicPlan extends Subscription {
    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 199.0;
    }
}