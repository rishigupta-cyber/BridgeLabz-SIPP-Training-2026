import java.util.Scanner;
public class DistanceConverter {
    public static void main(String[] args) {
        System.out.println("Enter distance in feet:");
        Scanner sc = new Scanner(System.in);
        double distanceInFeet = sc.nextDouble();
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f", distanceInFeet, yards, miles);
    }
}