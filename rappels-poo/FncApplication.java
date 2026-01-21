import java.util.List;
import java.util.stream.IntStream;

public class FncApplication {
    public static void main(String[] args) {
        // IfaceFonctionel iface = new IfaceFonctionel() {
        //     @Override
        //     public void demo(int a, int b) {
        //         System.out.println("DEMOOOO");
        //     }
        // };

        IfaceFonctionel iface = (a, b) -> {
            return a + b;
        };

        IfaceFonctionel iface2 = (a, b) -> a + b;

        iface.demo(0, 0);
        System.out.println(iface.getClass());


        List<String> prenoms = List.of("Jérémy", "Marion", "Albert");

        prenoms.stream()
            // .filter(prenom -> prenom.contains("m") || prenom.contains("M"))
            // .filter(prenom -> prenom.toUpperCase().contains("M"))
            .map(prenom -> prenom.toUpperCase())
            .filter(prenom -> prenom.contains("M"))
            .forEach(prenom -> System.out.println(prenom))
        ;

        System.out.println("----");

        prenoms.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println)
        ;

        List<Integer> entiers = List.of(5, 42, 741, 100, 85);

        int total = 0;

        // for (Integer val : entiers) {
        //     total += val;
        // }

        // entiers.stream().forEach(val -> total += val); // KO

        int result = entiers.stream()
            .reduce(0, (tot, val) -> tot + val)
            .intValue()
        ;

        result = entiers.stream()
            .reduce(0, Integer::sum)
            .intValue()
        ;
        System.out.println(result);

    }
}
