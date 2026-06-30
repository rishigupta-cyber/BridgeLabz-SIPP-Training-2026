public class RescueOperationsAnalyzer {

    static RescueTeam findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam t : teams) {
            if (t.location.equalsIgnoreCase(location)) {
                return t;
            }
        }
        return null;
    }

    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("Teams with ID starting with '" + prefix + "':");
        for (RescueTeam t : teams) {
            if (t.teamId.startsWith(prefix)) {
                System.out.println(t.teamId + " at " + t.location);
            }
        }
    }

    static void countTeamsByCategory(RescueTeam[] teams) {
        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (RescueTeam t : teams) {
            if (t instanceof MedicalTeam) {
                medicalCount++;
            } else if (t instanceof FireRescueTeam) {
                fireCount++;
            } else if (t instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        System.out.println("Medical Teams: " + medicalCount + " | Fire Rescue Teams: " + fireCount + " | Food Supply Teams: " + foodCount);

        String maxCategory = "Medical Team";
        int maxCount = medicalCount;

        if (fireCount > maxCount) {
            maxCategory = "Fire Rescue Team";
            maxCount = fireCount;
        }
        if (foodCount > maxCount) {
            maxCategory = "Food Supply Team";
            maxCount = foodCount;
        }

        System.out.println("Category with maximum deployments: " + maxCategory + " (" + maxCount + " teams)");
    }
}