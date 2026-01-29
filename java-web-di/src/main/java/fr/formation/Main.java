package fr.formation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import fr.formation.http.HttpServer;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        // Pour configurer les loggers
        Configurator.setRootLevel(Level.DEBUG);

        log.error("Le message à débug : {}, {}", "var1", "var2");

        ApplicationContext ctx = new WebApplicationContext(Main.class.getPackageName());

        new Thread(() -> {
            ctx.getBean(HttpServer.class).serve();
        }).start();
    }
}
