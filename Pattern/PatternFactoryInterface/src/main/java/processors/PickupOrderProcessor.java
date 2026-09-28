package processors;

import orders.Order;
import orders.PickupOrder;

public class PickupOrderProcessor extends AbstractOrderProcessor {

    @Override
    public Order createOrder() {
        return new PickupOrder("Bob", "Downtown Branch");
    }
}
