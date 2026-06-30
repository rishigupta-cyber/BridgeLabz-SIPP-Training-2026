public class EducationalCourse {

    static class Course {
        String courseName;
        int duration;

        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        void displayDetails() {
            System.out.println("Course: " + courseName + " | Duration: " + duration + " weeks");
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        void displayDetails() {
            super.displayDetails();
            System.out.println("Platform: " + platform + " | Recorded: " + isRecorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        void displayDetails() {
            super.displayDetails();
            double finalFee = fee - (fee * discount / 100);
            System.out.println("Fee: Rs." + fee + " | Discount: " + discount + "% | Final Fee: Rs." + finalFee);
        }
    }

    public static void main(String[] args) {
        Course course1 = new Course("Basic Mathematics", 4);
        OnlineCourse course2 = new OnlineCourse("Web Development", 8, "Udemy", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Data Science Bootcamp", 12, "Coursera", true, 15000.0, 20.0);

        course1.displayDetails();
        System.out.println();
        course2.displayDetails();
        System.out.println();
        course3.displayDetails();
    }
}