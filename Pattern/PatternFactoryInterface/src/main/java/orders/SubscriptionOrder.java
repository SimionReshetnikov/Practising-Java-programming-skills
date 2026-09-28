package orders;

public class SubscriptionOrder implements Order {

    private final String customerName;
    private final String frequency;

    public SubscriptionOrder(String customerName, String frequency) {
        this.customerName = customerName;
        this.frequency = frequency;
    }

    @Override
    public String getType() { return "Subscription"; }

    @Override
    public void validate() {
        if (!frequency.equals("weekly") && !frequency.equals("biweekly")) {
            throw new IllegalStateException("Invalid subscription frequency: " + frequency);
        }
        System.out.println("Subscription validated: " + frequency);
    }

    @Override
    public void confirm() {
        System.out.println("Subscription confirmed for " + customerName);
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Email sent to " + customerName + ": subscription active.");
    }

    @Override
    public void sendToKitchen() {
        System.out.println("Subscription order scheduled.");
    }
}
