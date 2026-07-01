public class Resume<T extends JobRole> {
    String candidateName;
    int experienceYears;
    T jobRole;

    Resume(String candidateName, int experienceYears, T jobRole) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.jobRole = jobRole;
    }

    boolean isEligible() {
        return experienceYears >= jobRole.minExperienceYears;
    }

    void displayResume() {
        System.out.println("Candidate: " + candidateName + " | Role: " + jobRole.roleName + " | Experience: " + experienceYears + " years");
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
        System.out.println("Status: " + (isEligible() ? "Eligible" : "Not Eligible"));
    }
}