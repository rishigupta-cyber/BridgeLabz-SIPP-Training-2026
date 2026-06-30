public class FamilyPlan extends Subscription {
    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 799.0;
    }
}