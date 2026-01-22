import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApplication {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Schedulers
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        executor.submit(() ->{
            System.out.println(Thread.currentThread().getName());
        });

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Coucou");
        }, 10, 1, TimeUnit.SECONDS);

    }
}
