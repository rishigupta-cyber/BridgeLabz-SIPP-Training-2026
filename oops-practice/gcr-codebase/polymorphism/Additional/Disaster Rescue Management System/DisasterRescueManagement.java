public class DisasterRescueManagement {

    public static void main(String[] args) {
        RescueTeam[] teams = new RescueTeam[6];
        teams[0] = new MedicalTeam("MED01", "Riverside Village");
        teams[1] = new FireRescueTeam("FIRE01", "Hillside Town");
        teams[2] = new FoodSupplyTeam("FOOD01", "Riverside Village");
        teams[3] = new MedicalTeam("MED02", "Coastal Area");
        teams[4] = new FireRescueTeam("FIRE02", "Hillside Town");
        teams[5] = new FoodSupplyTeam("FOOD02", "Coastal Area");

        System.out.println("--- Performing Rescue Duties ---");
        for (RescueTeam t : teams) {
            t.performDuty();
        }

        System.out.println();
        String searchLocation = "Hillside Town";
        RescueTeam found = RescueOperationsAnalyzer.findTeamByLocation(teams, searchLocation);
        if (found != null) {
            System.out.println("Team found at " + searchLocation + ": " + found.teamId);
        } else {
            System.out.println("No team found at " + searchLocation);
        }

        System.out.println();
        RescueOperationsAnalyzer.displayTeamsByPrefix(teams, "FIRE");

        System.out.println("\n--- Deployment Summary ---");
        RescueOperationsAnalyzer.countTeamsByCategory(teams);
    }
}