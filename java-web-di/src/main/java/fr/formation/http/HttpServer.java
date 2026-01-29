package fr.formation.http;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.formation.WebApplicationContext;
import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;

@Component
public class HttpServer {
    @Inject
    private WebApplicationContext ctx;

    public void serve() {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        try {
            ServerSocket server = new ServerSocket(80);

            System.out.println("Démarrage du serveur HTTP sur le port 80!");

            while (true) {
                Socket client = server.accept();

                executor.submit(() -> {
                    new HttpClient().handle(this.ctx, client);
                });
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
