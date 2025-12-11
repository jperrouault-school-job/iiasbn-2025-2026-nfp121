import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> prenoms = List.of("prenom1", "prenom2", "prenom3", "prenom4", "prenom5");
        // Iterator<String> it = prenoms.iterator();

        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }

        for (String prenom : prenoms) {
            System.out.println(prenom);
        }
    }
}