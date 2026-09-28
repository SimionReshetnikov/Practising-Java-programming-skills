package orders;

public class CateringOrder implements Order {

    private final String customerName;
    private final int guestCount;

    public CateringOrder(String customerName, int guestCount) {
        this.customerName = customerName;
        this.guestCount = guestCount;
    }

    @Override
    public String getType() { return "Catering"; }

    @Override
    public void validate() {
        if (guestCount < 10) {
            throw new IllegalStateException("Catering requires at least 10 guests.");
        }
        System.out.println("Catering validated for " + guestCount + " guests.");
    }

    @Override
    public void confirm() {
        System.out.println("Catering menu confirmed for " + customerName);
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Email sent to " + customerName + ": catering scheduled.");
    }

    @Override
    public void sendToKitchen() {
        System.out.println("Catering order sent to kitchen.");
    }
}
