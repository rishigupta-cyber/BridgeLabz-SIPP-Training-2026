import java.util.Scanner;

public class NumberCheckerPart5 {

    public static int sumOfProperDivisors(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }

        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return sumOfProperDivisors(number) < number;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum = sum + factorial(digit);
            temp = temp / 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Is perfect number: " + isPerfectNumber(number));
        System.out.println("Is abundant number: " + isAbundantNumber(number));
        System.out.println("Is deficient number: " + isDeficientNumber(number));
        System.out.println("Is strong number: " + isStrongNumber(number));

        sc.close();
    }
}