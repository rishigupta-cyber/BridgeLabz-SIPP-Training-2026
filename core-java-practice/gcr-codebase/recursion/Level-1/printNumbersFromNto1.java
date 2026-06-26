import java.util.*;

public class printNumbersFromNto1 {
    public static int printNumber(int n){
        int d=0;
        if(n==0){
            return 0;
        }
        System.out.print(n+" ");
        return printNumber(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        System.out.println(printNumber(n));
    }
}