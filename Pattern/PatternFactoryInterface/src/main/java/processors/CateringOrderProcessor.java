package processors;

import orders.CateringOrder;
import orders.Order;

public class CateringOrderProcessor extends AbstractOrderProcessor {

    @Override
    public Order createOrder() {
        return new CateringOrder("Carol", 25);
    }
}
