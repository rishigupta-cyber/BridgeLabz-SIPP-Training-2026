public class UniversitySystem {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }

    static class Student extends Person {
        final String studentId;
        double gpa;

        Student(String name, int age, String studentId, double gpa) {
            super(name, age);
            this.studentId = studentId;
            this.gpa = gpa;
        }

        public String toString() {
            return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
        }
    }

    static class GradStudent extends Student {
        String thesis;

        GradStudent(String name, int age, String studentId, double gpa, String thesis) {
            super(name, age, studentId, gpa);
            this.thesis = thesis;
        }

        public String toString() {
            return super.toString() + ", Thesis: " + thesis;
        }
    }

    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Neha Kulkarni", 24, "STU2001", 8.9, "Deep Learning for Healthcare");

        System.out.println(gs);

        System.out.println("gs instanceof GradStudent: " + (gs instanceof GradStudent));
        System.out.println("gs instanceof Student: " + (gs instanceof Student));
        System.out.println("gs instanceof Person: " + (gs instanceof Person));

        Person p = gs;
        Student s = gs;
        System.out.println(p);
        System.out.println(s);
    }
}