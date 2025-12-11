public class OperateurApplication {
    public static void main(String[] args) {
        // Opérateurs
        // + - / * % & | ^ ~ >> >>> <<

        // Affectation -> opérateur / expression qui retournera le résultat affecté
        int a = 5;

        // decalage();
        // andOr();
        andOrXorNot();
    }

    public static void andOrXorNot() {
        int a = 5;  // 101
        int b = 3;  // 011

        // AND &
        // Il faut avoir 1 partout pour avoir 1, sinon c'est 0
        System.out.println(a & b);
        System.out.println(Integer.toBinaryString(a & b));

        // OR |
        // 0 et 0 donne 0, sinon c'est 1
        System.out.println(a | b);
        System.out.println(Integer.toBinaryString(a | b));

        // XOR ^
        // 1 et 0 font 1, 0 et 0 font 0, 1 et 1 font 0
        System.out.println(a ^ b);
        System.out.println(Integer.toBinaryString(a ^ b));

        // NOT ~
        // on inverse tous les bits
        System.out.println(~a);
        System.out.println(Integer.toBinaryString(~a));

        // On inverse le signe
        System.out.println(-a);
        System.out.println(Integer.toBinaryString(-a));
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
