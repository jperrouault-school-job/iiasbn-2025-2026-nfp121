import java.util.function.Consumer;

import client.FileSender;

public class SocketClientApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Démrrage du client ...");

        Consumer<Boolean> onReceive = (isReceiveOk) -> {
            if (isReceiveOk) {
                System.out.println("La copie a été faite sur le serveur !");
            }

            else {
                System.out.println("Erreur lors de la copie !");
            }
        };

        Thread t1 = new Thread(createTask(onReceive, "premier.txt"));
        Thread t2 = new Thread(createTask(onReceive, "deuxieme.txt"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Terminé !!");
    }

    private static Runnable createTask(Consumer<Boolean> onReceive, String filename) {
        return () -> {
            try (FileSender sender = FileSender.connect()) {
                sender.setOnReceive(onReceive);
                sender.send(filename);
            }

            catch (Exception e) {
                System.out.println("Impossible de se connecter au serveur !");
            }
        };
    }
}
