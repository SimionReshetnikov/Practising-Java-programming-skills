import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) {

        List<OrderProcessing> tasks = List.of(
                new OrderProcessing(new Order("Svetlana", 7000)),
                new OrderProcessing(new Order("Nicolay", 10000)),
                new OrderProcessing(new Order("Elena", 4000)),
                new OrderProcessing(new Order("Evgenii", 8000))
        );

        try (ExecutorService threadPool = Executors.newFixedThreadPool(4)) {
            for (OrderProcessing taskOrderProcessing : tasks) {
                threadPool.execute(taskOrderProcessing);
            }
            threadPool.shutdown();
            if (threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Все заказы отработаны.");
            } else {
                System.out.println("Не все заказы отработаны.");
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
