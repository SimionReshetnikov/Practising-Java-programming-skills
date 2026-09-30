package processors;

import context.OperationContext;
import transactions.BankOperation;

public abstract class AbstractOperationProcessor implements OperationProcessor {

    private static int processedCount = 0;

    @Override
    public abstract BankOperation createOperation(OperationContext context);

    @Override
    public final void processOperation(OperationContext context) {
        BankOperation bankOperation;

        try {
            bankOperation = createOperation(context);
            bankOperation.validate();
        } catch (IllegalArgumentException ex) {
            System.out.println("Операция отклонена: " + ex.getMessage());
            return;
        }

        bankOperation.confirm();
        bankOperation.operation();
        bankOperation.customerNotification();

        processedCount++;
        System.out.println("Операция выполнена " + bankOperation.getType());
        System.out.println("---");
    }

    public static int getProcessedCount() {
        return processedCount;
    }
}
