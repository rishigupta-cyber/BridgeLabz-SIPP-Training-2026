import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    static HashMap<String, ArrayList<String>> attendanceMap = new HashMap<>();

    static void markAttendance(String subject, String studentName) {
        attendanceMap.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> studentsPresent = attendanceMap.get(subject);

        if (studentsPresent.contains(studentName)) {
            System.out.println(studentName + " is already marked present for " + subject);
        } else {
            studentsPresent.add(studentName);
            System.out.println(studentName + " marked present for " + subject);
        }
    }

    static void displayAttendance() {
        System.out.println("--- Attendance by Subject ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            System.out.println("\nSubject: " + entry.getKey());
            for (String student : entry.getValue()) {
                System.out.println(" - " + student);
            }
            System.out.println("Total present: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        markAttendance("Java Programming", "Rohit Sharma");
        markAttendance("Java Programming", "Neha Kulkarni");
        markAttendance("Data Structures", "Rohit Sharma");
        markAttendance("Data Structures", "Vikram Singh");
        markAttendance("Java Programming", "Rohit Sharma");
        markAttendance("Data Structures", "Anita Desai");

        System.out.println();
        displayAttendance();
    }
}