import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();

        System.out.print("Enter Amar's height: ");
        double amarHeight = sc.nextDouble();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = sc.nextDouble();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = sc.nextDouble();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (youngestAge == amarAge) {
            System.out.println("Youngest friend is Amar with age " + amarAge);
        } else if (youngestAge == akbarAge) {
            System.out.println("Youngest friend is Akbar with age " + akbarAge);
        } else {
            System.out.println("Youngest friend is Anthony with age " + anthonyAge);
        }

        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (tallestHeight == amarHeight) {
            System.out.println("Tallest friend is Amar with height " + amarHeight);
        } else if (tallestHeight == akbarHeight) {
            System.out.println("Tallest friend is Akbar with height " + akbarHeight);
        } else {
            System.out.println("Tallest friend is Anthony with height " + anthonyHeight);
        }
    }
}