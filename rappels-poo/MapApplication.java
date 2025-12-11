import java.util.HashMap;
import java.util.Map;

public class MapApplication {
    public static void main(String[] args) {
        Map<String, String> strings = new HashMap<>();

        strings.put("A", "A");
        strings.put("B", "B");
        strings.put("C", "C");
        strings.put("A", "A2");

        strings.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
