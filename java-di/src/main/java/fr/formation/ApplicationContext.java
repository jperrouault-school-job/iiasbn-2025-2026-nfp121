package fr.formation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.formation.annotation.Component;
import fr.formation.annotation.Controller;
import fr.formation.annotation.Inject;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApplicationContext {
    protected Map<Class<?>, Object> instances = new HashMap<>();

    public ApplicationContext(String packageName) {
        // Auto-référence
        this.instances.put(this.getClass(), this);

        Set<Class<?>> classes = this.findAllClassesByPackage(packageName);

        // Gestion des instances
        for (Class<?> clz : classes) {
            if (clz.isAnnotationPresent(Component.class) || clz.isAnnotationPresent(Controller.class)) {
                this.instances.put(clz, BeanFactory.createBean(clz));
            }
        }

        // Injection des dépendances
        for (Class<?> clz : classes) {
            this.inject(clz);
        }
    }

    public <T> T getBean(Class<T> clz) {
        return (T) this.instances.get(clz);
    }

    private Set<Class<?>> findAllClassesByPackage(String packageName) {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replace(".", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Set<Class<?>> classes = new HashSet<>();

        for (String line : reader.lines().toList()) {
            if (line.endsWith(".class")) {
                String className = packageName + "." + line.substring(0, line.length() - 6);
                log.trace("Classe trouvée : {} !", className);

                try {
                    classes.add(Class.forName(className));
                }

                catch (ClassNotFoundException e) {
                    log.error("Impossible de charger la classe {} : {}", className, e.getMessage());
                }

            }

            else {
                classes.addAll(this.findAllClassesByPackage(packageName + "." + line));
            }
        }

        return classes;
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
                        log.error("Problème à l'injection : {} ", e.getMessage());
                    }
                }
            }
        }
    }
}
