public class FoodSupplyTeam extends RescueTeam {
    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (Food Supply Team) is distributing food and water supplies at " + location);
    }
}