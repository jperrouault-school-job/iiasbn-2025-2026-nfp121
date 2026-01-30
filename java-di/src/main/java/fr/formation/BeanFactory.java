package fr.formation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BeanFactory {
    private BeanFactory() { }

    public static <T> T createBean(Class<T> clz) {
        try {
            log.debug("Intanciation de la classe {} ...", clz.getName());
            return clz.getDeclaredConstructor().newInstance();
        }

        catch (Exception e) {
            log.error("Impossible d'instancier la classe {} : {}", clz.getName(), e.getMessage());
        }

        return null;
    }
}
