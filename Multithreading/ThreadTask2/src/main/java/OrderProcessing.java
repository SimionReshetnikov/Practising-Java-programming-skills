public class OrderProcessing implements Runnable {

    private final Order order;

    public OrderProcessing(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            System.out.println("Обработка заказа №" + order.getOrderId() + " для " +
                    order.getCustomerName());
            Thread.sleep(order.getProcessingTime());
            System.out.println("Заказ №" + order.getOrderId() + " обработан.");
        } catch (InterruptedException ex) {
            System.out.println("Обработка заказа №" + order.getOrderId() + " была прервана.");
        }

    }
}
