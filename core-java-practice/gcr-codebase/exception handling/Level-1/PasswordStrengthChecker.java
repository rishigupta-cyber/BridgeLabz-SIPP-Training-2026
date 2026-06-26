public class PasswordStrengthChecker {

    static void checkPassword(String password) {
        System.out.println("\nChecking password: " + (password == null ? "null" : "\"" + password + "\""));

        try {
            if (password == null) {
                throw new NullPointerException("Password cannot be null.");
            }

            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty.");
            }

            if (password.length() < 8) {
                throw new IllegalArgumentException("Password too short. Minimum 8 characters required. Current length: " + password.length() + ".");
            }

            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("First character must be uppercase. Got: '" + password.charAt(0) + "'.");
            }

            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Last character must be a digit. Got: '" + password.charAt(password.length() - 1) + "'.");
            }

            String specialChars = "@#$%&*";
            boolean hasSpecial = false;
            for (char c : password.toCharArray()) {
                if (specialChars.indexOf(c) != -1) {
                    hasSpecial = true;
                    break;
                }
            }
            if (!hasSpecial) {
                throw new IllegalArgumentException("Password must contain at least one special character (@, #, $, %, &, *).");
            }

            System.out.println("Password is STRONG. All rules passed.");

        } catch (NullPointerException e) {
            System.out.println("Null Error       : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Weak Password    : " + e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String Error     : Unable to read characters. Password may be malformed.");
        }
    }

    public static void main(String[] args) {
        checkPassword(null);
        checkPassword("");
        checkPassword("Ab@3");
        checkPassword("alllowercase@3");
        checkPassword("Uppercase@X");
        checkPassword("NoSpecial3");
        checkPassword("Nospecia");
        checkPassword("Valid@Pa55");
    }
}