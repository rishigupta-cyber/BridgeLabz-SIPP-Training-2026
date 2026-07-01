import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystem {

    static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("--- Resume Screening Results ---");
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResume();
            System.out.println();
        }
    }

    static void displayEligibleCandidates(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("--- Eligible Candidates ---");
        for (Resume<? extends JobRole> resume : resumes) {
            if (resume.isEligible()) {
                System.out.println(resume.candidateName + " qualified for " + resume.jobRole.roleName);
            }
        }
    }

    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();

        resumes.add(new Resume<>("Rohit Sharma", 3, new SoftwareEngineer()));
        resumes.add(new Resume<>("Neha Kulkarni", 1, new SoftwareEngineer()));
        resumes.add(new Resume<>("Vikram Singh", 4, new DataScientist()));
        resumes.add(new Resume<>("Anita Desai", 2, new DataScientist()));
        resumes.add(new Resume<>("Suresh Patil", 5, new ProductManager()));
        resumes.add(new Resume<>("Pooja Iyer", 3, new ProductManager()));

        screenResumes(resumes);
        displayEligibleCandidates(resumes);
    }
}