package processors;

import context.OperationContext;
import transactions.BankOperation;
import transactions.Deposit;

public class DepositProcessor extends AbstractOperationProcessor {

    @Override
    public BankOperation createOperation(OperationContext context) {
        return new Deposit(context.getBankAccount(), context.getAmount());
    }
}
