import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {

    public static int sumUsingRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number greater than 0");
        } else {
            int recursionResult = sumUsingRecursion(n);
            int formulaResult = sumUsingFormula(n);

            System.out.println("Sum using recursion: " + recursionResult);
            System.out.println("Sum using formula: " + formulaResult);

            if (recursionResult == formulaResult) {
                System.out.println("Both results match, the computation is correct");
            } else {
                System.out.println("The results do not match");
            }
        }

        sc.close();
    }
}