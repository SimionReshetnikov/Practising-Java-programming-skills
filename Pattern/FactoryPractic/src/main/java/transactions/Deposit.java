package transactions;

import accounts.BankAccount;

import java.math.BigDecimal;

public class Deposit implements BankOperation {

    private BankAccount bankAccount;
    private BigDecimal amount;

    public Deposit(BankAccount bankAccount, BigDecimal amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public String getType() {
        return "Deposit";
    }

    @Override
    public void validate() {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Переданы некорректные данные по банковскому аккаунту.");
        }

        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть меньше или равна нулю.");
        }

        System.out.println("Проверка пройдена, данные по банковскому аккаунту и сумме пополнения корректные.");
    }

    @Override
    public void operation() {
        BigDecimal newAmount = bankAccount.getAmountMoney().add(amount);
        bankAccount.setAmountMoney(newAmount);
    }

    @Override
    public void confirm() {
        System.out.println("Пополнение баланса на сумму " + amount + " подтверждено.");
    }

    @Override
    public void customerNotification() {
        System.out.println("Пополнение баланса карты успешно завершено. Заберите карту.");
    }
}
