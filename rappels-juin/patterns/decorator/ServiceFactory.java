package patterns.decorator;

public class ServiceFactory {
    private ServiceFactory() { }

    public static PrenomService createPrenomService() {
        PrenomService service = new PrenomService();

        service = new TransactionDecorator(service);
        service = new JournalDecorator(service);

        return service;
    }
}
