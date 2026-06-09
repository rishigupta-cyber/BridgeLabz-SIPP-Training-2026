import java.util.Scanner;
public class SquareSide {
    public static void main(String[] args) {
        System.out.println("Enter perimeter:");
        Scanner sc = new Scanner(System.in);
        double perimeter = sc.nextDouble();
        double side = perimeter / 4;
        System.out.printf("The length of the side is %.2f whose perimeter is %.2f", side, perimeter);
    }
}