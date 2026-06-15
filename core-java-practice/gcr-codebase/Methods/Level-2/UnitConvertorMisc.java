public class UnitConvertorMisc {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        System.out.println("100 F is " + convertFahrenheitToCelsius(100) + " C");
        System.out.println("37 C is " + convertCelsiusToFahrenheit(37) + " F");
        System.out.println("10 pounds is " + convertPoundsToKilograms(10) + " kg");
        System.out.println("10 kg is " + convertKilogramsToPounds(10) + " pounds");
        System.out.println("10 gallons is " + convertGallonsToLiters(10) + " liters");
        System.out.println("10 liters is " + convertLitersToGallons(10) + " gallons");
    }
}