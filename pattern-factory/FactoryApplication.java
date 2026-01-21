import java.util.Collection;

public class FactoryApplication {
    public static void main(String[] args) {
        Collection<String> strings = CollectionFactory.createCollection(true, true);
        Collection<String> strings2 = CollectionFactory.createCollection(false, true);

        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("A");

        strings.forEach(System.out::println);
    }
}
