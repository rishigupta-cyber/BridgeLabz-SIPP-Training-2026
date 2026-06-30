public class FireRescueTeam extends RescueTeam {
    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (Fire Rescue Team) is extinguishing fires and rescuing trapped people at " + location);
    }
}