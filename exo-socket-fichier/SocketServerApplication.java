import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerApplication {
    public static void main(String[] args) {
        System.out.println("Démarrage du serveur ...");

        try (ServerSocket server = new ServerSocket(1234)) {
            Socket client = server.accept();
            byte[] buffer = new byte[5];

            System.out.println("Connexion entrante !");

            int len;

            try (FileOutputStream fos = new FileOutputStream("copie.txt")) {
                System.out.println("Copie en cours ...");

                // Si utilisation d'un marqueur de fin EOF ou de la taille indiquée, l'algo sera différent
                while ((len = client.getInputStream().read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                System.out.println("Copie faite !");

                client.getOutputStream().write(1);
            }

            catch (Exception e) {
                System.out.println("Erreur lors de la copie du fichier !");

                client.getOutputStream().write(0);
            }
        }

        catch (Exception e) {
            System.out.println("Impossible de créer le serveur !");
        }
    }
}
