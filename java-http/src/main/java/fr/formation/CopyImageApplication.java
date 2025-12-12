package fr.formation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CopyImageApplication {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://i.pinimg.com/564x/8b/f7/c6/8bf7c6e26f7250944e963f23f364b68f.jpg"))
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            byte[] result = response.body();

            try (FileOutputStream fos = new FileOutputStream("/workspace/chat.jpg")) {
                fos.write(result);
            }
        }

        catch (URISyntaxException ex) {
            System.out.println("Problème d'URI !");
        }

        catch (InterruptedException | IOException ex) {
            System.out.println("Problème de requête HTTP !");
        }
    }
}