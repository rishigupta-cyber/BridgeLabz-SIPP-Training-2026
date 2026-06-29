public class HospitalManagementSystem {
    final String patientID;
    String name;
    int age;
    String ailment;
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    HospitalManagementSystem(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    void displayDetails(Object obj) {
        if (obj instanceof HospitalManagementSystem) {
            System.out.println("Hospital: " + hospitalName + ", Patient ID: " + patientID + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment);
        }
    }

    static void getTotalPatients() {
        System.out.println("Total patients admitted: " + totalPatients);
    }

    public static void main(String[] args) {
        HospitalManagementSystem p1 = new HospitalManagementSystem("Sunita Rao", 45, "Diabetes", "PT2001");
        HospitalManagementSystem p2 = new HospitalManagementSystem("Arjun Mehta", 30, "Fracture", "PT2002");

        p1.displayDetails(p1);
        p2.displayDetails(p2);

        HospitalManagementSystem.getTotalPatients();
    }
}