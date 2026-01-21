import java.util.HashSet;
import java.util.Set;

public class SetApplication {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("A");

        strings.forEach(System.out::println);
    }
}
