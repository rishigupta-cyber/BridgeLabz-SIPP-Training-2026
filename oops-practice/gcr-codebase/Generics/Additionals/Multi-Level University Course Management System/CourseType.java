public abstract class CourseType {
    String evaluationType;

    CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    abstract void evaluate();
}