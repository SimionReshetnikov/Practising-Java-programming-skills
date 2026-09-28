package orders;

public interface Order {

    String getType();
    void validate();
    void confirm();
    void notifyCustomer();
    void sendToKitchen();
}
