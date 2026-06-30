interface LuggageScanner {
    boolean scanLuggage(String passengerName);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage guideline: No sharp objects, liquids over 100ml, or flammable items allowed");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport guideline: Passport must be valid and not expired before boarding");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.length() == 8;
    }
}

public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    public boolean scanLuggage(String passengerName) {
        return !passengerName.equalsIgnoreCase("Suspicious Item Found");
    }

    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    public void displaySecurityGuidelines() {
        System.out.println("Combined guideline: All passengers must clear both luggage scan and passport verification");
    }

    public static void main(String[] args) {
        String[] passengerNames = {"Rohit Sharma", "Neha Kulkarni", "Vikram Singh", "Anita Desai"};
        String[] passportNumbers = {"A1234567", "B987654", "C2233445", "D11"};

        AirportSecuritySystem security = new AirportSecuritySystem();

        security.displaySecurityGuidelines();
        System.out.println();

        for (int i = 0; i < passengerNames.length; i++) {
            boolean luggageOk = security.scanLuggage(passengerNames[i]);
            boolean passportOk = security.verifyPassport(passportNumbers[i]);

            if (luggageOk && passportOk) {
                System.out.println(passengerNames[i] + " - Cleared for boarding");
            } else {
                System.out.println(passengerNames[i] + " - Denied boarding (Luggage OK: " + luggageOk + ", Passport OK: " + passportOk + ")");
            }
        }
    }
}