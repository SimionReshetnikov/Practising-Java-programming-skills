package processors;

import context.OperationContext;
import transactions.BankOperation;

public interface OperationProcessor {

    BankOperation createOperation(OperationContext context);
    void processOperation(OperationContext context);

    public static OperationProcessor forType(String nameOperation) {
        if (nameOperation == null) {
            throw new IllegalArgumentException("Тип операции не может быть null.");
        }

        return switch (nameOperation.toLowerCase()) {
            case "withdrawal" -> new CashWithdrawalProcessor();
            case "deposit" -> new DepositProcessor();
            default -> throw new IllegalArgumentException("Неизвестный тип операции: " + nameOperation);
        };
    }
}
