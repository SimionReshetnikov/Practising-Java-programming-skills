package orders;

public class PickupOrder implements Order {

    private final String customerName;
    private final String pickupPoint;

    public PickupOrder(String customerName, String pickupPoint) {
        this.customerName = customerName;
        this.pickupPoint = pickupPoint;
    }

    @Override
    public String getType() {
        return "Pickup";
    }

    @Override
    public void validate() {
        if (pickupPoint == null || pickupPoint.isBlank()) {
            throw new IllegalStateException("Pickup point is empty.");
        }

        System.out.println("Pickup point validated: " + pickupPoint);
    }

    @Override
    public void confirm() {
        System.out.println("Pickup confirmed for " + customerName);
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Push sent to " + customerName + ": ready for pickup.");
    }

    @Override
    public void sendToKitchen() {
        System.out.println("Order sent to kitchen for pickup.");
    }
}
