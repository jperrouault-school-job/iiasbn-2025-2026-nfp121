public class Photo {
    private int id;
    private String title;

    public Photo() { }
    public Photo(int id) { }
    private Photo(String title) { }
    public Photo(int id, String title) { }

    @DemoAnnotation
    public void demoAnnote() {
        System.out.println("Démonstration annotée !");
    }

    public void demoPasAnnote() {
        System.out.println("Démonstration pas annotée !");
    }
}
