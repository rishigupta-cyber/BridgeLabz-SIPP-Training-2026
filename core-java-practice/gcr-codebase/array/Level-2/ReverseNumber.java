import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int digitCount = 0;

        while (temp != 0) {
            temp = temp / 10;
            digitCount++;
        }

        int[] digits = new int[digitCount];
        int index = 0;

        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        int[] reversed = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversed[i] = digits[digitCount - 1 - i];
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversed[i]);
        }
        System.out.println();

        sc.close();
    }
}