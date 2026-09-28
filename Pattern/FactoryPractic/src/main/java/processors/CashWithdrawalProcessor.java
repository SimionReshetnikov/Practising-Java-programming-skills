package processors;

import context.OperationContext;
import transactions.BankOperation;
import transactions.CashWithdrawal;

public class CashWithdrawalProcessor extends AbstractOperationProcessor {

    @Override
    public BankOperation createOperation(OperationContext context) {
        return new CashWithdrawal(context.getBankAccount(), context.getAmount());
    }
}
