import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %.1f and %.1f is %.1f, %.1f, %.1f, and %.1f " , number1, number2, addition, subtraction, multiplication, division);
    }
}