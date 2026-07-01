import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {

    static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("--- All Courses ---");
        for (Course<? extends CourseType> course : courses) {
            course.displayCourseDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> dataStructures = new Course<>("Data Structures", "Computer Science", new ExamCourse());
        Course<AssignmentCourse> webDev = new Course<>("Web Development", "Information Technology", new AssignmentCourse());
        Course<ResearchCourse> aiMl = new Course<>("Artificial Intelligence", "Computer Science", new ResearchCourse());
        Course<ExamCourse> dbms = new Course<>("Database Management", "Computer Science", new ExamCourse());

        List<Course<? extends CourseType>> courseList = new ArrayList<>();
        courseList.add(dataStructures);
        courseList.add(webDev);
        courseList.add(aiMl);
        courseList.add(dbms);

        displayAllCourses(courseList);
    }
}