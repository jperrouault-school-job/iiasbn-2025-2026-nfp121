public class ExoHexaCouleurApplication {
    public static void main(String[] args) {
        int couleur = 0xAF56F8;

        // La couleur est codée sur 8 bits (1 octet => 0 à 255)
        // On veut décaler de 2, donc 2 * 8 -> 16
        int red = (couleur >>> (2 * 8));
        int green = (couleur >> 8) & 0xFF;
        int blue = couleur & 255;

        System.out.println("Rouge = " + red);
        System.out.println("Vert = " + green);
        System.out.println("Bleu = " + blue);
    }
}
