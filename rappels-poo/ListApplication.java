import java.util.ArrayList;
import java.util.List;

public class ListApplication {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("A");

        strings.forEach(System.out::println);
    }
}
