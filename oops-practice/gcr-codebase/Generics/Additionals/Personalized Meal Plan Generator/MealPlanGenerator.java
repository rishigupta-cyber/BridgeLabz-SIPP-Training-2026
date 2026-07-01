import java.util.ArrayList;
import java.util.List;

public class MealPlanGenerator {

    interface MealPlan {
        String getMealType();
        String getDescription();
    }

    static class VegetarianMeal implements MealPlan {
        public String getMealType() { return "Vegetarian"; }
        public String getDescription() { return "Plant-based meals with dairy and eggs"; }
    }

    static class VeganMeal implements MealPlan {
        public String getMealType() { return "Vegan"; }
        public String getDescription() { return "Fully plant-based, no animal products"; }
    }

    static class KetoMeal implements MealPlan {
        public String getMealType() { return "Keto"; }
        public String getDescription() { return "High fat, low carb meal plan"; }
    }

    static class HighProteinMeal implements MealPlan {
        public String getMealType() { return "High-Protein"; }
        public String getDescription() { return "Lean meats, eggs, and legumes focused"; }
    }

    static class Meal<T extends MealPlan> {
        String userName;
        T mealPlan;
        int durationDays;

        Meal(String userName, T mealPlan, int durationDays) {
            this.userName = userName;
            this.mealPlan = mealPlan;
            this.durationDays = durationDays;
        }

        void displayMealPlan() {
            System.out.println("User: " + userName + " | Plan: " + mealPlan.getMealType() + " | Duration: " + durationDays + " days");
            System.out.println("Description: " + mealPlan.getDescription());
        }
    }

    static <T extends MealPlan> Meal<T> generateMealPlan(String userName, T mealPlan, int durationDays) {
        if (durationDays <= 0) {
            System.out.println("Invalid duration for " + userName + ", minimum 1 day required");
            return null;
        }
        System.out.println("Generating " + mealPlan.getMealType() + " meal plan for " + userName);
        return new Meal<>(userName, mealPlan, durationDays);
    }

    static void displayAllPlans(List<? extends Meal<? extends MealPlan>> plans) {
        System.out.println("--- All Meal Plans ---");
        for (Meal<? extends MealPlan> meal : plans) {
            meal.displayMealPlan();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> plans = new ArrayList<>();

        plans.add(generateMealPlan("Rohit Sharma", new VegetarianMeal(), 30));
        plans.add(generateMealPlan("Neha Kulkarni", new VeganMeal(), 15));
        plans.add(generateMealPlan("Vikram Singh", new KetoMeal(), 0));
        plans.add(generateMealPlan("Anita Desai", new HighProteinMeal(), 45));

        System.out.println();
        displayAllPlans(plans.stream().filter(p -> p != null).collect(java.util.stream.Collectors.toList()));
    }
}