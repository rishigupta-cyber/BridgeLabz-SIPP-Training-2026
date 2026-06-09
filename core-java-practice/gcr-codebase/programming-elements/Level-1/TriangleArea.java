import java.util.Scanner;
public class TriangleArea {
    public static void main(String[] args) {
        System.out.println("Enter base:");
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        System.out.println("Enter height:");
        double height = sc.nextDouble();
        double areaSqInches = 0.5 * base * height;
        double areaSqCm = areaSqInches * 6.4516;
        System.out.printf("Your area in square inches is %.2f and square centimeters is %.2f", areaSqInches, areaSqCm);
    }
}