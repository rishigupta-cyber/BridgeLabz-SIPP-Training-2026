import java.util.Scanner;

public class PowerOfNumberFor {
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
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }
            System.out.println(number + " ^ " + power + " = " + result);
        }
    }
}