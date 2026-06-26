import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.println(isValid(username, 0));
    }

    static boolean isValid(String username, int index) {
        if (index == username.length()) return true;
        char ch = username.charAt(index);
        if (ch < 'a' || ch > 'z') return false;
        return isValid(username, index + 1);
    }
}