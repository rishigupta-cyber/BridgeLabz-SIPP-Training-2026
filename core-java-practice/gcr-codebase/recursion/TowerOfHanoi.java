import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        toh(n, 'A', 'C', 'B');
    }
    static void toh(int n, char src, char dest, char helper) {
        if (n == 0) return;
        toh(n-1, src, helper, dest);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        toh(n-1, helper, dest, src);
    }
} 