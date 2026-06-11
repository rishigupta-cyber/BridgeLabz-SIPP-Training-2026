import java.util.Scanner;

public class DigitFrequency {
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

        temp = number;
        while (temp != 0) {
            digits[index] = temp % 10;
            temp = temp / 10;
            index++;
        }

        int[] frequency = new int[10];

        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\nFrequency of each digit in " + number + ":");
        for (int i = 0; i <= 9; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " appears " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}