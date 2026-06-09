import java.util.Scanner;
public class HeightConverter {
    public static void main(String[] args) {
        System.out.println("Enter height:");
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double inches = height / 2.54;
        double feet = inches / 12;
        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f", height, feet, inches);
    }
}