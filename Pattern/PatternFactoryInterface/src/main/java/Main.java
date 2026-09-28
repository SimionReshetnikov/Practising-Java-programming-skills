import processors.AbstractOrderProcessor;
import processors.OrderProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<OrderProcessor> processors = List.of(
                OrderProcessor.forType("delivery"),
                OrderProcessor.forType("pickup"),
                OrderProcessor.forType("catering"),
                OrderProcessor.forType("subscription")
        );

        for (OrderProcessor processor : processors) {
            processor.processOrder();
        }

        System.out.println("Total processed: " + AbstractOrderProcessor.getProcessedCount());
    }
}
