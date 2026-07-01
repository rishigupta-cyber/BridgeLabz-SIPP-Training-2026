public class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment-Based");
    }

    public void evaluate() {
        System.out.println("Evaluation: Weekly assignments and project submissions");
    }
}