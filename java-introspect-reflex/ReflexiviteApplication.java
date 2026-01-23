import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflexiviteApplication {
    public static void main(String[] args) throws Exception {
        Constructor<Photo> ctor = Photo.class.getDeclaredConstructor(String.class);

        // Si le constructeur est privé, on peut le rendre accessible
        ctor.setAccessible(true);

        Photo laPhoto = ctor.newInstance("Le titre");

        System.out.println(laPhoto);

        Field fieldTitle = Photo.class.getDeclaredField("title");

        fieldTitle.setAccessible(true);

        fieldTitle.set(laPhoto, "Le nouveau titre");

        System.out.println(fieldTitle.get(laPhoto));

        for (Method method : Photo.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DemoAnnotation.class)) {
                method.invoke(laPhoto);
            }
        }

    }
}
