import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.FileReceiver;

public class SocketServerApplication {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("Démarrage du serveur ...");

        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                executor.submit(new FileReceiver(server.accept())::receive);
            }
        }

        catch (Exception e) {
            System.out.println("Impossible de créer le serveur !");
        }
    }
}
