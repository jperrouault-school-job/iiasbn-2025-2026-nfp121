import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IntrospectionApplication {
    public static void main(String[] args) throws NoSuchFieldException {
        // Pour faire de l'introspection, il faut la classe
        // Photo.class

        // Photo photo = new Photo();
        // photo.getClass()

        for (Constructor<?> ctor : Photo.class.getDeclaredConstructors()) {
            System.out.println(ctor.getName());
            System.out.println(ctor.getParameterCount());
        }

        System.out.println("--------------");

        for (Method method : Photo.class.getDeclaredMethods()) {
            System.out.println(method.getName());
            System.out.println(method.getParameterCount());

            DemoAnnotation annotation = method.getDeclaredAnnotation(DemoAnnotation.class);

            if (annotation != null) {
                System.out.println("La méthode " + method.getName() + " est annotée !!");
            }
        }

        System.out.println("--------------");

        for (Field field : Photo.class.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

        System.out.println("--------------");

        Field field = Photo.class.getDeclaredField("id");
        System.out.println(field.getType());
    }
}
