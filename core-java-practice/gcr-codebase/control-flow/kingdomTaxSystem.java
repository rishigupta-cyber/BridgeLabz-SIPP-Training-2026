import java.util.*;
public class kingdomTaxSystem {
    static double getTaxRate(double income){
        if(income < 10_000)         return 0.05;
        else if(income <= 50_000)   return 0.15;
        else                        return 0.30;
    }
    static String getBracket(double income){
        return (income < 10_000) ? "Low (%5)":
                (income <= 50_000) ? "Mid (%15)" : "High (30%)";
    }
    static void printCitizenTax(int id, double income){
        double tax = income * getTaxRate(income);
        System.out.printf("Citizen %-2d | Income: %9.2f | Bracket: %-11s | Tax: %9.2f%n", id, income, getBracket(income),tax);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of citizens:");
        int n =sc.nextInt();
        for(int i =1;i <= n;i++){
            System.out.printf("Enter income for citizen %d:", i);
            double income= sc.nextDouble();
            printCitizenTax(i, income);
        }
        sc.close();
    }
}
