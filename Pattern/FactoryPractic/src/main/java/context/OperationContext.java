package context;

import accounts.BankAccount;

import java.math.BigDecimal;

public class OperationContext {

    private final BankAccount bankAccount;
    private final BigDecimal amount;

    public OperationContext(BankAccount bankAccount, BigDecimal amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
