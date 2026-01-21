import java.util.Iterator;
import java.util.List;

public class IteratorApplication {
    // Pour voir le Bytecode généré :
    // > javac IteratorApplication.java
    // > javap -c IteratorApplication

    public static void main(String[] args) {
        List<String> prenoms = List.of("Jérémy", "Marion", "Thomas");

        // Iterator<String> it =prenoms.iterator();

        // while (it.hasNext()) {
        //     String val = it.next();

        //     System.out.println(val);
        // }

        // for (String val : prenoms) {
        //     System.out.println(val);
        // }

        for (var val : prenoms) {
            System.out.println(val);
        }
    }
}
