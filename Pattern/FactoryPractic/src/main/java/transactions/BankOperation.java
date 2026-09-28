package transactions;

public interface BankOperation {

    String getType();
    void validate();
    void confirm();
    void operation();
    void customerNotification();
    //void logEntry();
}
