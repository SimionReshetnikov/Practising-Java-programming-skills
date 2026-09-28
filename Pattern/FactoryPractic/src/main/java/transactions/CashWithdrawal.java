package transactions;

import accounts.BankAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashWithdrawal implements BankOperation {

    private BankAccount bankAccount;
    private final BigDecimal withdrawalAmount;

    public CashWithdrawal(BankAccount bankAccount, BigDecimal withdrawalAmount) {
        this.bankAccount = bankAccount;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public String getType() {
        return "Withdrawal";
    }

    @Override
    public void validate() {
        double amountMoney = bankAccount.conversionToDouble();

        if (amountMoney < withdrawalAmount.doubleValue() || withdrawalAmount.doubleValue() < 0) {
            throw new IllegalArgumentException("Сумма снятия ДС некорректна.");
        }

        System.out.println("Проверка пройдена, сумма для снятия " + withdrawalAmount + " корректна.");
    }

    @Override
    public void operation() {
        BigDecimal newAmount = bankAccount.getAmountMoney().subtract(withdrawalAmount);
        bankAccount.setAmountMoney(newAmount);
    }

    @Override
    public void confirm() {
        System.out.println("Снятие суммы " + withdrawalAmount + " подтверждено.");
    }

    @Override
    public void customerNotification() {
        System.out.println("Снятие проведено успешно. Заберите банковскую карту и денежные средства.");
    }
}
