package processors;

import context.OperationContext;
import transactions.BankOperation;

public interface OperationProcessor {

    BankOperation createOperation(OperationContext context);
    void processOperation(OperationContext context);
}
