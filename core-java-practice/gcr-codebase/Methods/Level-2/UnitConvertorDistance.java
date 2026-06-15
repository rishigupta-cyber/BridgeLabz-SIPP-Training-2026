public class UnitConvertorDistance {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        System.out.println("10 km is " + convertKmToMiles(10) + " miles");
        System.out.println("10 miles is " + convertMilesToKm(10) + " km");
        System.out.println("10 meters is " + convertMetersToFeet(10) + " feet");
        System.out.println("10 feet is " + convertFeetToMeters(10) + " meters");
    }
}