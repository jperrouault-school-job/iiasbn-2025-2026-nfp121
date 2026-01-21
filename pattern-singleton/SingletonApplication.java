import java.lang.reflect.Constructor;

public class SingletonApplication {
    public static void main(String[] args) throws Exception {
        DbContext db1 = DbContext.getInstance();
        DbContext db2 = DbContext.getInstance();

        System.out.println(db1 == db2);

        // Démo Instrospection + Reflexivité
        Constructor<DbContext> ctor = DbContext.class.getDeclaredConstructor();

        ctor.setAccessible(true);
        DbContext db3 = ctor.newInstance();

        System.out.println(db1 == db3);
    }
}
