import java.util.Scanner;
public class KmToMilesInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in km: ");
        double km = input.nextDouble();
        double miles = km / 1.6;
        System.out.printf("The total miles is %.2f mile for the given %.2f km", miles, km);
    }
}