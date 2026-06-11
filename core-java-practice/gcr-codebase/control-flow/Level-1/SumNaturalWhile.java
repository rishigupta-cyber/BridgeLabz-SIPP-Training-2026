import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0) {
            int sumWhile = 0;
            int i = 1;
            while (i <= number) {
                sumWhile += i;
                i++;
            }
            int sumFormula = number * (number + 1) / 2;

            System.out.println("Sum using formula = " + sumFormula);
            System.out.println("Sum using while loop = " + sumWhile);

            if (sumFormula == sumWhile) {
                System.out.println("Both results match");
            } else {
                System.out.println("Results do not match");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
    }
}