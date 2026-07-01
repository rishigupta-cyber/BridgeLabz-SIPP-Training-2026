public abstract class Category {
    String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String toString() {
        return categoryName;
    }
}