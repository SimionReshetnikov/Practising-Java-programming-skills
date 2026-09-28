package processors;

import orders.Order;
import orders.SubscriptionOrder;

public class SubscriptionOrderProcessor extends AbstractOrderProcessor {

    @Override
    public Order createOrder() {
        return new SubscriptionOrder("Dave", "weekly");
    }
}
