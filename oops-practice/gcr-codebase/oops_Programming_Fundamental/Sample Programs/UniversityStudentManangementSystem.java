public class UniversityStudentManangementSystem {
    final int rollNumber;
    String name;
    String grade;
    static String universityName = "Pune Institute of Technology";
    static int totalStudents = 0;

    UniversityStudentManangementSystem(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    void displayDetails(Object obj) {
        if (obj instanceof UniversityStudentManangementSystem) {
            System.out.println("University: " + universityName + ", Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade);
        }
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    public static void main(String[] args) {
        UniversityStudentManangementSystem s1 = new UniversityStudentManangementSystem("Neha Kulkarni", 301, "A");
        UniversityStudentManangementSystem s2 = new UniversityStudentManangementSystem("Vikram Singh", 302, "B+");

        s1.displayDetails(s1);
        s2.displayDetails(s2);

        s1.updateGrade("A+");
        System.out.println("Updated grade for " + s1.name + ": " + s1.grade);

        UniversityStudentManangementSystem.displayTotalStudents();
    }
}