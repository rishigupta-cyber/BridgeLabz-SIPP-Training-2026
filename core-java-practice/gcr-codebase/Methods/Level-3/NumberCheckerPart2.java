import java.util.Scanner;

public class NumberCheckerPart2 {

    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        if (temp == 0) {
            return 1;
        }

        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        return count;
    }

    public static int[] storeDigits(int number, int digitCount) {
        int[] digits = new int[digitCount];
        int temp = number;

        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        return digits;
    }

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum = sum + digit;
        }
        return sum;
    }

    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum = sum + Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = findSumOfDigits(digits);
        if (sumOfDigits == 0) {
            return false;
        }
        return number % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }

        for (int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        System.out.println("Sum of digits: " + findSumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + findSumOfSquares(digits));
        System.out.println("Is harshad number: " + isHarshadNumber(number, digits));

        int[][] frequency = findDigitFrequency(digits);
        System.out.println("Digit frequency:");
        for (int[] row : frequency) {
            if (row[1] > 0) {
                System.out.println("Digit " + row[0] + " occurs " + row[1] + " time(s)");
            }
        }

        sc.close();
    }
}