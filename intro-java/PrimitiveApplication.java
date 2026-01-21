public class PrimitiveApplication {
    public static void main(String[] args) {
        // Type primitifs

        // Entiers
        int a = 5;          // 4 octets
        Integer b = null;
        long c = 5;         // 8 octets
        short d = 5;        // 2 octets
        byte e = 5;         // 1 octet

        // Caractères
        char f = '5';       // 2 octets
        char g = 53;

        // Vrai / Faux
        boolean h = true;   // 1 bit | 1 octet voire 2

        // Virgules flottantes
        float i = 5;        // 4 octets
        double j = 5;       // 8 octets


        // Les bases
        int k = 0b101;  // Base 2 binaire
        int l = 0xff;   // Base 16 Hexa
        int m = 013;    // Base 8 octal

        // Troncatures
        int n = 1000;
        byte o = (byte)n;

        // Voir les valeurs en Binaire
        System.out.println(Integer.toBinaryString(o));
    }
}
