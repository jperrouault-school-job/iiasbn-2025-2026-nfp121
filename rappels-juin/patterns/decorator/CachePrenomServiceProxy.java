package patterns.decorator;

import java.util.List;

public class CachePrenomServiceProxy extends PrenomService {
    private final PrenomService prenomService;
    private List<String> cache;

    public CachePrenomServiceProxy(PrenomService prenomService) {
        this.prenomService = prenomService;
    }

    @Override
    public List<String> findAll() {
        if (this.cache == null) {
            this.cache = this.prenomService.findAll();
            System.out.println("Mise en cache !");
        }

        else {
            System.out.println("Utilisation du cache ...");
        }

        return this.cache;
    }
}
