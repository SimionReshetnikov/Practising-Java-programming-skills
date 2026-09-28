package processors;

import orders.DeliveryOrder;
import orders.Order;

public class DeliveryOrderProcessor extends AbstractOrderProcessor {

    @Override
    public Order createOrder() {
        return new DeliveryOrder("Alice", "Baker Street 221B");
    }
}
