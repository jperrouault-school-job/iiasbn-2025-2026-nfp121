package fr.formation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import fr.formation.annotation.Inject;

public class ApplicationContext {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public ApplicationContext(Class<?>... classes) {
        // Auto-référence
        this.instances.put(ApplicationContext.class, this);

        // Gestion des instances
        for (Class<?> clz : classes) {
            this.instances.put(clz, BeanFactory.createBean(clz));
        }

        // Injection des dépendances
        for (Class<?> clz : classes) {
            this.inject(clz);
        }
    }

    public <T> T getBean(Class<T> clz) {
        return (T) this.instances.get(clz);
    }

    private void inject(Class<?> clz) {
        Object instance = this.instances.get(clz);

        for (Field field : clz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);

                Object dependency = this.instances.get(field.getType());

                if (dependency != null) {
                    try {
                        field.set(instance, dependency);
                    }

                    catch (Exception e) {
                        System.out.println("Problème à l'injection : " + e.getMessage());
                    }
                }
            }
        }
    }
}
