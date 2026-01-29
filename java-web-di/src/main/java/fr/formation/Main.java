package fr.formation;

import fr.formation.http.HttpServer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new WebApplicationContext(Main.class.getPackageName());

        new Thread(() -> {
            ctx.getBean(HttpServer.class).serve();
        }).start();
    }
}
