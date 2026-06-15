import java.util.Scanner;

public class NumberCheckerPart3 {

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

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);
        int[] reversed = reverseArray(digits);

        System.out.print("Original digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.print("Reversed digits: ");
        for (int digit : reversed) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is palindrome: " + isPalindrome(digits));
        System.out.println("Is duck number: " + isDuckNumber(digits));

        sc.close();
    }
}