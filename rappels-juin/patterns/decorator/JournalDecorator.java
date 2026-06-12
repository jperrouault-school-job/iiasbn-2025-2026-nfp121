package patterns.decorator;

import java.util.List;

public class JournalDecorator extends PrenomService {
    private final PrenomService prenomService;

    public JournalDecorator(PrenomService prenomService) {
        this.prenomService = prenomService;
    }

    @Override
    public List<String> findAll() {
        System.out.println("Journalisation ...");

        return this.prenomService.findAll();
    }
}
