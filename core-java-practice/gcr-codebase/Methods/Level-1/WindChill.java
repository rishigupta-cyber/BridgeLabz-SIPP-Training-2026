import java.util.Scanner;

public class WindChill {

    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16))
                + (0.4275 * temperature * Math.pow(windSpeed, 0.16));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the temperature (F): ");
        double temperature = sc.nextDouble();

        System.out.print("Enter the wind speed (mph): ");
        double windSpeed = sc.nextDouble();

        WindChill wc = new WindChill();
        double result = wc.calculateWindChill(temperature, windSpeed);

        System.out.println("The wind chill temperature is " + result);

        sc.close();
    }
}