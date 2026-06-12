package patterns.decorator;

import java.util.List;

public class PrenomService {
    public List<String> findAll() {
        System.out.println("Liste des prénoms ...");

        return List.of("Albert", "Bernard", "Cécile");
    }
}
