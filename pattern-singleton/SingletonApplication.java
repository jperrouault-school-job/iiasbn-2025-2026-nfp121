public class SingletonApplication {
    public static void main(String[] args) {
        DbContext db1 = DbContext.getInstance();
        DbContext db2 = DbContext.getInstance();

        System.out.println(db1 == db2);
    }
}
