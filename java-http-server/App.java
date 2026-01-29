import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        try {
            ServerSocket server = new ServerSocket(80);

            while (true) {
                Socket client = server.accept();

                executor.submit(() -> {
                    new HttpClient().handle(client);
                });
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
