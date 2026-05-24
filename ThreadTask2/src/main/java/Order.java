public class Order {

    private int orderId;
    private static int count = 0;
    private String customerName;
    private long processingTime;

    public Order(String customerName, long processingTime) {
        customerNameValidation(customerName);
        processingTimeValidation(processingTime);
        this.orderId = ++count;
        this.customerName = customerName;
        this.processingTime = processingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    private void customerNameValidation(String customerName) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Поле с именем клиента не может быть пустым.");
        }
    }

    private void processingTimeValidation(long processingTime) {
        if (processingTime < 0 || processingTime > 60000) {
            throw new IllegalArgumentException("Значение должно быть в диапазоне [0, 60000]");
        }
    }
}
