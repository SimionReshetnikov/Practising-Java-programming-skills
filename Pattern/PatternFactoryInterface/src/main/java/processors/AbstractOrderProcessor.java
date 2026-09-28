package processors;

import orders.Order;

public abstract class AbstractOrderProcessor implements OrderProcessor {

    private static int processedCount = 0;

    @Override
    public abstract Order createOrder();

    @Override
    public final void processOrder() {

        Order order;

        try {
            order = createOrder();
            order.validate();
        } catch (IllegalStateException ex) {
            System.out.println("Order failed: " + ex.getMessage());
            return;
        }

        order.confirm();
        order.notifyCustomer();
        order.sendToKitchen();

        processedCount++;
        System.out.println("Order processed: " + order.getType());
        System.out.println("---");
    }

    public static int getProcessedCount() {
        return processedCount;
    }
}
