import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        if (number < 1 || power < 1) {
            System.out.println("Please enter positive integers.");
        } else {
            int result = 1;
            int counter = 0;
            while (counter != power) {
                result = result * number;
                counter++;
            }
            System.out.println(number + " ^ " + power + " = " + result);
        }
    }
}