public class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager", 4);
    }

    public String getRequiredSkills() {
        return "Product Strategy, Agile, Stakeholder Management";
    }
}