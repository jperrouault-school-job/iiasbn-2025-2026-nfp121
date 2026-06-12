package patterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class TransactionDecorator extends PrenomService {
    private final PrenomService prenomService;

    public TransactionDecorator(PrenomService prenomService) {
        this.prenomService = prenomService;
    }

    @Override
    public List<String> findAll() {
        System.out.println("Démarrage de la transaction ...");

        try {
            List<String> result = this.prenomService.findAll();

            System.out.println("Commit de la transaction ...");

            return result;
        }

        catch (Exception ex) {
            System.out.println("Rollback de la transaction!");

            return new ArrayList<>();
        }
    }
}
