import java.util.Scanner;

public class SumUntilZeroBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = sc.nextDouble();
            if (input <= 0) {
                break;
            }
            total += input;
        }
        System.out.println("Total = " + total);
    }
}