package patterns.decorator;

public class ExoDecoratorApplication {
    public static void main(String[] args) {
        PrenomService service = ServiceFactory.createPrenomService();

        service.findAll();
        service.findAll();
        service.findAll();
    }
}
