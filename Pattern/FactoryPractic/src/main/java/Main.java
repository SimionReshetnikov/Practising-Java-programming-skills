import accounts.BankAccount;
import context.OperationContext;
import processors.AbstractOperationProcessor;
import processors.OperationProcessor;

import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Misha");
        Map<String, OperationProcessor> processors = Map.of(
                "deposit", OperationProcessor.forType("deposit"),
                "withdrawal", OperationProcessor.forType("withdrawal")
        );

        processors.get("deposit").processOperation(
                new OperationContext(bankAccount, new BigDecimal("1000.00")));
        processors.get("withdrawal").processOperation(
                new OperationContext(bankAccount, new BigDecimal("300.00")));

        System.out.println("Всего выполнено операций: " + AbstractOperationProcessor.getProcessedCount());
        System.out.println("Итоговая сумма на счете: " + bankAccount.getAmountMoney());
    }
}
