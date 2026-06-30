interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

public class ShoppingCart implements CouponValidator {

    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.startsWith("SAVE") || code.startsWith("OFF");
    }

    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "OFF50", "XY", "DISCOUNT2026", "SAVE5", "FREESHIP"};

        ShoppingCart cart = new ShoppingCart();

        for (String code : coupons) {
            boolean isValid = cart.validateCoupon(code);
            System.out.println("Coupon " + code + " is " + (isValid ? "valid" : "invalid"));
        }
    }
}