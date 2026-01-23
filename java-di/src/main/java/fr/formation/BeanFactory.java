package fr.formation;

public class BeanFactory {
    private BeanFactory() { }

    public static <T> T createBean(Class<T> clz) {
        try {
            return clz.getDeclaredConstructor().newInstance();
        }

        catch (Exception e) {
            System.out.println("Impossible d'instancier la classe " + clz.getName() + " : " + e.getMessage());
        }

        return null;
    }
}
