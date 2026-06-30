public class MedicalTeam extends RescueTeam {
    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (Medical Team) is providing first aid and medical care at " + location);
    }
}