import java.util.Scanner;

public class NumberCheckerPart4 {

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

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int digitCount = countDigits(square);
        int[] digits = storeDigits(square, digitCount);

        int sum = 0;
        for (int digit : digits) {
            sum = sum + digit;
        }

        return sum == number;
    }

    public static boolean isSpyNumber(int[] digits) {
        int sum = 0;
        int product = 1;

        for (int digit : digits) {
            sum = sum + digit;
            product = product * digit;
        }

        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        long square = (long) number * number;
        String squareStr = String.valueOf(square);
        String numberStr = String.valueOf(number);

        return squareStr.endsWith(numberStr);
    }

    public static boolean isBuzzNumber(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        System.out.println("Is prime: " + isPrime(number));
        System.out.println("Is neon number: " + isNeonNumber(number));
        System.out.println("Is spy number: " + isSpyNumber(digits));
        System.out.println("Is automorphic number: " + isAutomorphicNumber(number));
        System.out.println("Is buzz number: " + isBuzzNumber(number));

        sc.close();
    }
}