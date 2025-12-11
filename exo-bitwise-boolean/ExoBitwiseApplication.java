public class ExoBitwiseApplication {
    public static void main(String[] args) {
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool3 = true;
        byte result = 0;

        if (bool1) {
            result = 1 << 2;
        }

        if (bool2) {
            // result = (byte)(result | (1 << 1));
            result |= 1 << 1;
        }

        if (bool3) {
            // result |= 1 << 0;
            result |= 1;
        }

        System.out.println("Valeur => " + result);
        System.out.println("Valeur binaire => " + Integer.toBinaryString(result));

        System.out.println("-- Solution #1 pour la relecture --");

        System.out.println((result >>> 2) == 1);
        System.out.println((result >>> 1) == 1);
        System.out.println((1 & (result >>> 0)) == 1);

        System.out.println("-- Solution #2 pour la relecture --");

        System.out.println((result & (1 << 2)) != 0);
        System.out.println((result & (1 << 1)) != 0);
        System.out.println((result & 1) != 0);
    }
}
