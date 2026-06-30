import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SpaceMissionCrewManagement {
    static HashMap<String, List<Astronaut>> missionCrew = new HashMap<>();
    static HashMap<String, HashSet<String>> missionAssignedIds = new HashMap<>();

    static class Astronaut {
        String astronautId;
        String name;
        String specialization;

        Astronaut(String astronautId, String name, String specialization) {
            this.astronautId = astronautId;
            this.name = name;
            this.specialization = specialization;
        }

        public String toString() {
            return "ID: " + astronautId + ", Name: " + name + ", Specialization: " + specialization;
        }
    }

    static void addMission(String missionName) {
        missionCrew.putIfAbsent(missionName, new ArrayList<>());
        missionAssignedIds.putIfAbsent(missionName, new HashSet<>());
        System.out.println("Mission added: " + missionName);
    }

    static void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrew.containsKey(missionName)) {
            System.out.println("Mission " + missionName + " does not exist");
            return;
        }

        HashSet<String> assignedIds = missionAssignedIds.get(missionName);

        if (assignedIds.contains(astronaut.astronautId)) {
            System.out.println(astronaut.name + " is already assigned to " + missionName);
            return;
        }

        missionCrew.get(missionName).add(astronaut);
        assignedIds.add(astronaut.astronautId);
        System.out.println(astronaut.name + " assigned to " + missionName);
    }

    static void displayAllMissions() {
        System.out.println("--- Mission Crew Details ---");
        for (Map.Entry<String, List<Astronaut>> entry : missionCrew.entrySet()) {
            System.out.println("\nMission: " + entry.getKey());
            for (Astronaut a : entry.getValue()) {
                System.out.println(" - " + a);
            }
            System.out.println("Total astronauts assigned: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        addMission("Artemis II");
        addMission("Mars Voyager");

        Astronaut a1 = new Astronaut("AST101", "Rohit Sharma", "Pilot");
        Astronaut a2 = new Astronaut("AST102", "Neha Kulkarni", "Mission Specialist");
        Astronaut a3 = new Astronaut("AST103", "Vikram Singh", "Flight Engineer");

        assignAstronaut("Artemis II", a1);
        assignAstronaut("Artemis II", a2);
        assignAstronaut("Artemis II", a1);
        assignAstronaut("Mars Voyager", a3);
        assignAstronaut("Mars Voyager", a1);

        System.out.println();
        displayAllMissions();
    }
}