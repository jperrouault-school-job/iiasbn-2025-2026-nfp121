import java.util.concurrent.TimeUnit;

public class PhotoService {
    public void methodPasSchedulee() {
        System.out.println("Méthode pas exécutée");
    }

    @Scheduled
    public void methodS1() {
        System.out.println("Toutes les secondes");
    }

    @Scheduled(frequency = 2)
    public void methodS2() {
        System.out.println("Toutes les 2 secondes");
    }

    @Scheduled(frequency = 500, unit = TimeUnit.MILLISECONDS)
    public void methodS3() {
        System.out.println("Toutes les 500 ms");
    }
}
