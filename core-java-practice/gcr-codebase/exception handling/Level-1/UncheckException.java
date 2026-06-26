import java.util.Scanner;
import java.util.InputMismatchException;

public class UncheckException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter dividend: ");
            int a = sc.nextInt();
            System.out.print("Enter divisor: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only.");
        }
    }
}