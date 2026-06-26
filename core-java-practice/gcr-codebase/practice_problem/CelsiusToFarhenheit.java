import java.util.*;
public class CelsiusToFarhenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature in celsius:");
        float celsius = sc.nextFloat();
        float fahrenheit= (celsius * 9/5) + 32;
        System.out.printf("Temprature in Fahrenheit: %.2f",fahrenheit);
    }
}
