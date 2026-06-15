public class UnitConvertorLength {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        System.out.println("10 yards is " + convertYardsToFeet(10) + " feet");
        System.out.println("10 feet is " + convertFeetToYards(10) + " yards");
        System.out.println("10 meters is " + convertMetersToInches(10) + " inches");
        System.out.println("10 inches is " + convertInchesToMeters(10) + " meters");
        System.out.println("10 inches is " + convertInchesToCentimeters(10) + " cm");
    }
}