package accounts;

import java.math.BigDecimal;

public class BankAccount {

    private String name;
    private BigDecimal amountMoney;

    public BankAccount(String name) {
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
        this.amountMoney = amountMoney;
    }

    public double conversionToDouble() {
        return amountMoney.doubleValue();
    }
}
