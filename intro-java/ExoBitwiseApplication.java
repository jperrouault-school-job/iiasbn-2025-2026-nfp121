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
    }
}
