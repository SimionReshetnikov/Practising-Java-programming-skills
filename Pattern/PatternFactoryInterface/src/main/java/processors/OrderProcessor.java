package processors;

import orders.Order;

public interface OrderProcessor {

    Order createOrder();
    void processOrder();

    static OrderProcessor forType(String type) {
        return switch (type.toLowerCase()) {
            case "delivery" -> new DeliveryOrderProcessor();
            case "pickup" -> new PickupOrderProcessor();
            case "catering" -> new CateringOrderProcessor();
            case "subscription" -> new SubscriptionOrderProcessor();
            default -> throw new IllegalArgumentException("Unknow order type: " + type);
        };
    }
}
