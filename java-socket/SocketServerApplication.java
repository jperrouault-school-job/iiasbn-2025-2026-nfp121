import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerApplication {
    public static void main(String[] args) {
        // Serveur TCP : avoir quelque chose qui écoute / attend sur un port
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Le serveur écoute sur le port " + port);

            // Permettre d'attendre la connexion d'un client
            Socket client = server.accept();

            System.out.println("Une connexion est arrivée !");

            byte[] value = { (byte)client.getInputStream().read() };
            System.out.println(new String(value));
        }

        catch (Exception e) {
            System.out.println("Problème socket !");
        }

    }
}
