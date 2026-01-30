package fr.formation.http;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.formation.WebApplicationContext;
import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.chainofresp.AcceptHeaderFilter;
import fr.formation.chainofresp.AuthenticationFilter;
import fr.formation.chainofresp.DispatcherFilter;
import fr.formation.chainofresp.ExceptionHandleFilter;
import fr.formation.chainofresp.LoggerFilter;
import fr.formation.chainofresp.RequestProcessingFilter;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class HttpServer {
    private static int SERVER_PORT = 80;

    @Inject
    private WebApplicationContext ctx;

    @Inject
    private RequestProcessingFilter requestProcessingFilter;

    public void serve() {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        log.debug("Configuration des filtres (Chain of Resp.)");

        this.requestProcessingFilter
            .setNext(this.ctx.getBean(LoggerFilter.class))
            .setNext(this.ctx.getBean(AuthenticationFilter.class))
            .setNext(this.ctx.getBean(DispatcherFilter.class))
            .setNext(this.ctx.getBean(ExceptionHandleFilter.class))
            .setNext(this.ctx.getBean(AcceptHeaderFilter.class))
        ;

        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            log.debug("Démarrage du serveur HTTP sur le port {}!", SERVER_PORT);

            while (true) {
                Socket client = server.accept();

                executor.submit(() -> {
                    new HttpClient().handle(this.requestProcessingFilter, client);
                });
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
