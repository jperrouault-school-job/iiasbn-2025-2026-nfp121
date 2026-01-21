import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CollectionFactory {
    private CollectionFactory() { }

    public static <T> Collection<T> createCollection(boolean linked, boolean duplicates) {
        if (linked) {
            if (duplicates) {
                return new LinkedList<>();
            }

            return new LinkedHashSet<>();
        }

        if (duplicates) {
            return new ArrayList<>();
        }

        return new HashSet<>();
    }
}
