package patterns.decorator;

import java.util.List;

public class PrenomService {
    public List<String> findAll() {
        try {
            Thread.sleep(2_000);
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Liste des prénoms ...");

        return List.of("Albert", "Bernard", "Cécile");
    }
}
