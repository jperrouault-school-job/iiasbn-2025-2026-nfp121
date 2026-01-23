package fr.formation;

import java.lang.reflect.Field;

import fr.formation.annotation.Inject;

public class BeanFactory {
    private BeanFactory() { }

    public static <T> T createBean(Class<T> clz) {
        try {
            T instance = clz.getDeclaredConstructor().newInstance();

            for (Field field : clz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);

                    // Attention ici, on instanciera autant de fois le type de classe qu'on a d'Inject => pas un Singleton
                    field.set(instance, createBean(field.getType()));
                }
            }

            return instance;
        }

        catch (Exception e) {
            System.out.println("Impossible d'instancier la classe " + clz.getName() + " : " + e.getMessage());
        }

        return null;
    }
}
