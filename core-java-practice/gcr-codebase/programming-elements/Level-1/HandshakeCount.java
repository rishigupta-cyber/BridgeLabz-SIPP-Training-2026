import java.util.Scanner;
public class HandshakeCount {
    public static void main(String[] args) {
        System.out.println("Enter number of students:");
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println(handshakes);
    }
}