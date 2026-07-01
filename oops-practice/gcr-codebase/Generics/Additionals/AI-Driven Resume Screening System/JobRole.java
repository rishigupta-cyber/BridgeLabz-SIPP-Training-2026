public abstract class JobRole {
    String roleName;
    int minExperienceYears;

    JobRole(String roleName, int minExperienceYears) {
        this.roleName = roleName;
        this.minExperienceYears = minExperienceYears;
    }

    abstract String getRequiredSkills();
}