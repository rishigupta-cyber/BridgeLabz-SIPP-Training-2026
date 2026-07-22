import java.util.PriorityQueue;
import java.util.Scanner;

public class ERTriageQueue {

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    static PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    static void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    static Patient treatNext() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        addPatient(new Patient("Alice", 3));
        addPatient(new Patient("Bob", 9));
        addPatient(new Patient("Charlie", 6));
        addPatient(new Patient("Diana", 1));

        System.out.println("Treating patients in order of severity:");
        while (!triageQueue.isEmpty()) {
            Patient p = treatNext();
            System.out.println("Patient: " + p.name + " | Severity: " + p.severity);
        }
    }
}