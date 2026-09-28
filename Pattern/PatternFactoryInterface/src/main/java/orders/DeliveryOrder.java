package orders;

public class DeliveryOrder implements Order {

    private final String customerName;
    private final String address;

    public DeliveryOrder(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
    }

    @Override
    public String getType() {
        return "Delivery";
    }

    @Override
    public void validate() {
        if (address == null || address.isBlank()) {
            throw new IllegalStateException("Delivery address is empty.");
        }
        System.out.println("Address validated: " + address);
    }

    @Override
    public void confirm() {
        System.out.println("Delivery confirmed for " + customerName);
    }

    @Override
    public void notifyCustomer() {
        System.out.println("SMS send to " + customerName + ": courier on the way.");
    }

    @Override
    public void sendToKitchen() {
        System.out.println("Order sent to kitchen for delivery.");
    }
}
