package accounts;

import java.math.BigDecimal;

public class BankAccount {

    private String name;
    private BigDecimal amountMoney;

    public BankAccount(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        this.name = name;
        amountMoney = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(BigDecimal amountMoney) {
        if (amountMoney == null) {
            throw new IllegalArgumentException("Сумма не может быть null.");
        }
        if (amountMoney.signum() < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной.");
        }
        this.amountMoney = amountMoney;
    }
}
