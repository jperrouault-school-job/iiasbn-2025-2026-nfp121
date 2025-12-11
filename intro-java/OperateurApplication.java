public class OperateurApplication {
    public static void main(String[] args) {
        // Opérateurs
        // + - / * % & | ^ ~ >> >>> <<

        // Affectation -> opérateur / expression qui retournera le résultat affecté
        int a = 5;

        // decalage();
        andOr();
    }

    public static void andOr() {
        // System.out.println(alwaysTrue() || alwaysFalse());
        // System.out.println(alwaysTrue() | alwaysFalse());

        // System.out.println(alwaysFalse() && alwaysTrue());
        System.out.println(alwaysFalse() & alwaysTrue());
    }

    public static boolean alwaysTrue() {
        System.out.println("TRUE");
        return true;
    }

    public static boolean alwaysFalse() {
        System.out.println("FALSE");
        return false;
    }

    public static void decalage() {
        byte a = 5;

        // Décalage vers la gauche
        // <<
        // On introduit des 0 sur la droite, autant de 0 que le décalage
        System.out.println(Integer.toBinaryString(a << 2));

        byte b = -5;
        System.out.println(Integer.toBinaryString(b));

        // Décalage vers la droite
        // >>
        // On introduit le bit de signe sur la gauche, autant de 0 ou 1 que le décalage
        System.out.println(Integer.toBinaryString(b >> 1));

        // >>>
        // On introduit des 0 sur la gauche, autant de 0 que le décalage
        System.out.println(Integer.toBinaryString(b >>> 1));
    }
}
