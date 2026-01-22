import java.io.FileInputStream;
import java.net.Socket;

public class SocketClientApplication {
    public static void main(String[] args) {
        System.out.println("Démrrage du client ...");

        try (Socket client = new Socket("127.0.0.1", 1234)) {
            System.out.println("Connexion OK !");
            byte[] buffer = new byte[5];

            try (FileInputStream fis = new FileInputStream("fichier.txt")) {
                int len;

                while ((len = fis.read(buffer)) != -1) {
                    client.getOutputStream().write(buffer, 0, len);
                }

                client.shutdownOutput(); // Attention, on ne pourra plus rien envoyer après - utiliser un marqueur de fin EOF ou bien indiquer la taille en début de transfert
                System.out.println("Fichier envoyé !");

                int result = client.getInputStream().read();

                if (result == 0) {
                    System.out.println("Erreur lors de l'envoi !");
                }

                else {
                    System.out.println("Envoi OK !");
                }
            }
        }

        catch (Exception e) {
            System.out.println("Impossible de se connecter au serveur !");
        }
    }
}
