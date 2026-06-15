import java.util.Scanner;

public class NumberCheckerPart1 {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum = sum + (int) Math.pow(digit, digits.length);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[] { largest, secondLargest };
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[] { smallest, secondSmallest };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is duck number: " + isDuckNumber(digits));
        System.out.println("Is armstrong number: " + isArmstrongNumber(number, digits));

        int[] largestPair = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestPair[0] + ", Second largest: " + largestPair[1]);

        int[] smallestPair = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestPair[0] + ", Second smallest: " + smallestPair[1]);

        sc.close();
    }
}