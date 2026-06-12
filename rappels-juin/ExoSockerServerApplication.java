import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExoSockerServerApplication {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(3333)) {
            System.out.println("Démarrage du serveur HTTP sur le port 3333");

            while (true) {
                Socket client = server.accept();

                System.out.println("Client connecté !");

                executor.submit(() -> ExoSockerServerApplication.handle(client));
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handle(Socket client) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line = "";
            while (!(line = reader.readLine()).isEmpty()) {
                System.out.println(line);
            }

            client.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
