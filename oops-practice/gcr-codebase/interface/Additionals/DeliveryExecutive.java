interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Tracking food order: Order is being prepared and will be picked up soon");
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder() {
        System.out.println("Tracking grocery order: Items are being packed at the nearest store");
    }

    static String generateDeliveryCode() {
        int code = (int) (Math.random() * 9000) + 1000;
        return "DEL" + code;
    }
}

public class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    public void deliverFood(String customerName) {
        System.out.println("Delivering food order to " + customerName);
    }

    public void deliverGrocery(String customerName) {
        System.out.println("Delivering grocery order to " + customerName);
    }

    public void trackOrder() {
        System.out.println("Tracking combined order: Executive is en route with both food and grocery items");
    }

    public static void main(String[] args) {
        String[] customerNames = {"Meena Shah", "Suresh Patil", "Vikram Singh", "Neha Kulkarni"};

        DeliveryExecutive executive = new DeliveryExecutive();

        for (int i = 0; i < customerNames.length; i++) {
            String deliveryCode = GroceryDelivery.generateDeliveryCode();

            if (i % 2 == 0) {
                executive.deliverFood(customerNames[i]);
            } else {
                executive.deliverGrocery(customerNames[i]);
            }

            executive.trackOrder();
            System.out.println("Delivery Code: " + deliveryCode);
            System.out.println();
        }
    }
}