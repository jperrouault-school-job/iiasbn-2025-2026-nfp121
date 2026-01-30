package fr.formation;

import fr.formation.http.HttpServer;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new WebApplicationContext(Main.class.getPackageName());

        new Thread(() -> {
            ctx.getBean(HttpServer.class).serve();
        }).start();
    }
}
