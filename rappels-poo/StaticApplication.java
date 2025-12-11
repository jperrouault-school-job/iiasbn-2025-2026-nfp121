public class StaticApplication {
    public static void main(String[] args) {
        // System.out.println(DemoStatic.a);

        new DemoStatic();
        new DemoStatic();
        DemoStatic ds1 = new DemoStatic();
        DemoStatic ds2 = new DemoStatic();
        DemoStatic ds3 = new DemoStatic();
        DemoStatic ds4 = new DemoStatic();

        System.out.println(ds1.id);
        System.out.println(ds4.id);

    }
}
