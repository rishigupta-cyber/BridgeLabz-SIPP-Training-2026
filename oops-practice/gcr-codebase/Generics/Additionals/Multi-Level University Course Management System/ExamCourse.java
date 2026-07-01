public class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam-Based");
    }

    public void evaluate() {
        System.out.println("Evaluation: Written exam with MCQ and descriptive questions");
    }
}