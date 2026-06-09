import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println("Enter number1:");
        Scanner sc = new Scanner(System.in);
        double number1 = sc.nextDouble();
        System.out.println("Enter number2:");
        double number2 = sc.nextDouble();
        double add = number1 + number2;
        double sub = number1 - number2;
        double mul = number1 * number2;
        double div = number1 / number2;
        System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f", number1, number2, add, sub, mul, div);
    }
}