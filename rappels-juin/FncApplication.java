import java.util.List;

public class FncApplication {
    public static void main(String[] args) {
        List<String> list = List.of("Toto", "Titi", "Tata", "a", "b");

        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        // IfaceFncDemo m1 = new IfaceFncDemo() {

        //     @Override
        //     public int maths(int a, int b) {
        //         return a + b;
        //     }

        // };

        IfaceFncDemo maths1 = (x, y) -> x + y;
        IfaceFncDemo maths2 = (x, y) -> FncApplication.add(x, y);
        IfaceFncDemo maths3 = FncApplication::add;
        IfaceFncDemo maths4 = Integer::sum;

        System.out.println(maths1.maths(5, 6));
        System.out.println(maths2.maths(5, 6));
        System.out.println(maths3.maths(5, 6));
        System.out.println(maths4.maths(5, 6));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
