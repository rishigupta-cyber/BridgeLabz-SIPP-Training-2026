import java.util.Scanner;

public class NumberArrayAnalysis {

    public static boolean isPositive(int number) {
        if (number >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is positive and even");
                } else {
                    System.out.println(numbers[i] + " is positive and odd");
                }
            } else {
                System.out.println(numbers[i] + " is negative");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);

        if (comparisonResult == 1) {
            System.out.println("The first element is greater than the last element");
        } else if (comparisonResult == -1) {
            System.out.println("The first element is less than the last element");
        } else {
            System.out.println("The first and last elements are equal");
        }

        sc.close();
    }
}