package server;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class FileReceiver {
    private static int HEADERS_SIZE = 13;
    private static int CONTENT_SIZE = 5;
    private static int FILENAME_LENGTH = 5;

    private final Socket client;

    public FileReceiver(Socket client) {
        this.client = client;

        System.out.println("Connexion entrante !");
    }

    public void receive() {
        byte[] headers = new byte[HEADERS_SIZE];
        byte[] buffer = new byte[CONTENT_SIZE];

        try {
            client.getInputStream().read(headers);
            String filename = new String(Arrays.copyOfRange(headers, 0, FILENAME_LENGTH));
            int remaining = 0;

            for (int i = 0; i < 8; i++) {
                remaining = (remaining << 8) | (headers[FILENAME_LENGTH + i] & 0xFF);
            }

            try (FileOutputStream fos = new FileOutputStream(filename + "-copy.txt")) {
                while (remaining > 0) {
                    int toRead = (int) Math.min(buffer.length, remaining);
                    int len = client.getInputStream().read(buffer, 0, toRead);

                    if (len == -1) {
                        throw new EOFException("Flux coupé avant la fin du fichier");
                    }

                    fos.write(buffer, 0, len);
                    remaining -= len;
                }

                System.out.println("Copie terminée !");
                client.getOutputStream().write(1);
            }

            catch (Exception e) {
                System.out.println("Erreur lors de la copie du fichier !");

                client.getOutputStream().write(0);
            }
        }

        catch (Exception e) {
            System.out.println("Erreur pendant lecture client");
        }
    }
}
