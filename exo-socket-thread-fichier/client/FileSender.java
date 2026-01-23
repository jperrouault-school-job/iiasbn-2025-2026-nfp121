package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class FileSender implements AutoCloseable {
    private static int HEADERS_SIZE = 13;
    private static int CONTENT_SIZE = 5;

    private Socket client;
    private Consumer<Boolean> onReceive;

    public void setOnReceive(Consumer<Boolean> onReceive) {
        this.onReceive = onReceive;
    }

    public static FileSender connect() throws UnknownHostException, IOException {
        FileSender sender = new FileSender();

        sender.client = new Socket("127.0.0.1", 1234);
        System.out.println("Connexion OK !");

        return sender;
    }

    public void send(String filename) {
        byte[] buffer = new byte[CONTENT_SIZE];

        try (FileInputStream fis = new FileInputStream(filename)) {
            int len;
            long fileSize = fis.getChannel().size();

            // En-têtes
            byte[] headers = new byte[HEADERS_SIZE];

            byte[] nameBytes = filename.getBytes(StandardCharsets.US_ASCII);
            System.arraycopy(nameBytes, 0, headers, 0, 5);

            for (int i = 0; i < 8; i++) {
                headers[5 + i] = (byte) (fileSize >>> (56 - i * 8));
            }

            this.client.getOutputStream().write(headers);

            while ((len = fis.read(buffer)) != -1) {
                this.client.getOutputStream().write(buffer, 0, len);
            }

            System.out.println("Fichier envoyé !");

            if (this.onReceive != null) {
                int result = this.client.getInputStream().read();

                this.onReceive.accept(result == 1);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas !");
        }

        catch (IOException e) {
            System.out.println("Impossible d'envoyer le fichier !");
        }
    }

    @Override
    public void close() throws Exception {
        if (this.client != null) {
            this.client.close();
        }
    }
}
