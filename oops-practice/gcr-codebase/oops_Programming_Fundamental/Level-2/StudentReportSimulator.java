public class StudentReportSimulator {
    String name;
    int rollNumber;
    double marks;

    StudentReportSimulator(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        StudentReportSimulator student1 = new StudentReportSimulator("Rishi Gupta", 21, 88.5);
        StudentReportSimulator student2 = new StudentReportSimulator("Sneha Patil", 22, 54.0);

        student1.displayDetails();
        System.out.println();
        student2.displayDetails();
    }
}