import java.util.List;

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
            .map(prenom -> prenom.toUpperCase())
            .forEach(prenom -> System.out.println(prenom))
        ;

        prenoms.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println)
        ;

    }
}
