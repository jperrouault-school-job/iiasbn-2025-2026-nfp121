import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Application {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        PhotoService service = new PhotoService();

        for (Method method : PhotoService.class.getDeclaredMethods()) {
            Scheduled schedule = method.getDeclaredAnnotation(Scheduled.class);

            if (schedule != null) {
                scheduler.scheduleAtFixedRate(() -> {
                    try {
                        method.invoke(service);
                    }

                    catch (Exception e) {
                        System.out.println("Erreur pas possible");
                    }
                }, 0, schedule.frequency(), schedule.unit());
            }
        }
    }
}
