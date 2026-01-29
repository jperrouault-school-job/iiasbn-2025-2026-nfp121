package fr.formation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import fr.formation.annotation.Controller;
import fr.formation.annotation.GetMapping;
import fr.formation.http.WebMethod;
import lombok.Getter;

public class WebApplicationContext extends ApplicationContext {
    @Getter
    private Map<String, WebMethod> methods = new HashMap<>();

    public WebApplicationContext(String packageName) {
        super(packageName);

        for (Object instance : this.instances.values()) {
            Class<?> clz = instance.getClass();

            if (!clz.isAnnotationPresent(Controller.class)) {
                continue;
            }

            for (Method m : clz.getDeclaredMethods()) {
                GetMapping mapping = m.getAnnotation(GetMapping.class);

                if (mapping == null) {
                    continue;
                }

                methods.put(mapping.value(), WebMethod.builder()
                    .instance(instance)
                    .method(m)
                    .build()
                );
            }
        }
    }
}
