public class Course<T extends CourseType> {
    String courseName;
    String department;
    T courseType;

    Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + " | Department: " + department + " | Type: " + courseType.evaluationType);
        courseType.evaluate();
    }
}