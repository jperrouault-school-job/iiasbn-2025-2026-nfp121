import java.util.List;

public class ExoFncApplication {
    public static void main(String[] args) {
        List<String> list = List.of("Toto", "Titi", "Tata", "a", "b");

        list.stream()
            // .map(s -> s.toUpperCase())
            .map(String::toUpperCase)
            .forEach(System.out::println)
        ;

        // Compter le nombre de caractères au TOTAL -> afficher le total

        int tot = list.stream()
            // .map(s -> s.length())
            .map(String::length)
            // .reduce(0, (total, valeur) -> total + valeur)
            .reduce(0, Integer::sum)
        ;

        int tot2 = list.stream()
            // .map(s -> s.length())
            .mapToInt(String::length)
            .sum()
        ;

        System.out.println("Total = " + tot);
        System.out.println("Total 2 = " + tot2);
    }
}
