class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    void displayPgDetails() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", Specialization: " + specialization + ", CGPA: " + getCgpa());
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Neha Kulkarni", 8.5, "Computer Science");
        pg.displayPgDetails();

        pg.setCgpa(9.0);
        System.out.println("Updated CGPA: " + pg.getCgpa());
    }
}