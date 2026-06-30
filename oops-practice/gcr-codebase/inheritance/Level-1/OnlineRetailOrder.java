public class OnlineRetailOrder {

    static class Order {
        String orderId;
        String orderDate;

        Order(String orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        String getOrderStatus() {
            return "Order placed";
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        ShippedOrder(String orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        String getOrderStatus() {
            return "Order shipped, tracking number: " + trackingNumber;
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        String getOrderStatus() {
            return "Order delivered on " + deliveryDate;
        }
    }

    public static void main(String[] args) {
        Order order1 = new Order("ORD101", "2026-06-20");
        ShippedOrder order2 = new ShippedOrder("ORD102", "2026-06-21", "TRK998877");
        DeliveredOrder order3 = new DeliveredOrder("ORD103", "2026-06-18", "TRK556644", "2026-06-25");

        System.out.println(order1.orderId + " - " + order1.getOrderStatus());
        System.out.println(order2.orderId + " - " + order2.getOrderStatus());
        System.out.println(order3.orderId + " - " + order3.getOrderStatus());
    }
}