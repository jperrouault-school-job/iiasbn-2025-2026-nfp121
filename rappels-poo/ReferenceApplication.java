public class ReferenceApplication {
    public static void main(String[] args) {
        Integer a = 5;
        Personne p = new Personne();

        p.age = 5;
        // demoRef(a);
        demoRef(p);

        // System.out.println(a);
        System.out.println(p.age);
    }

    public static void demoRef(Integer a) {
        a = 6;
    }

    public static void demoRef(Personne p) {
        // p.age = 6 ;
        Personne p2 = new Personne();
        // p = new Personne();
        p.age = 6;

        // return p;
    }

    public static class Personne {
        public int age = 0;
    }
}
