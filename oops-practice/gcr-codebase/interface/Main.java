interface CouponValidator {
    void validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 6 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {
    private static final String[] validCoupons = {"SAVE10", "DISCOUNT20", "OFFER50"};

    @Override
    public void validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            System.out.println("Coupon \"" + code + "\" is INVALID (invalid length)");
            return;
        }

        boolean found = false;
        for (String validCode : validCoupons) {
            if (validCode.equalsIgnoreCase(code)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Coupon \"" + code + "\" is VALID");
        } else {
            System.out.println("Coupon \"" + code + "\" is INVALID (not found)");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] couponCodes = {"SAVE10", "HELLO", "DISCOUNT20", "XYZ", "OFFER50", "EXPIRED99"};

        ShoppingCart cart = new ShoppingCart();

        for (String code : couponCodes) {
            cart.validateCoupon(code);
        }
    }
}