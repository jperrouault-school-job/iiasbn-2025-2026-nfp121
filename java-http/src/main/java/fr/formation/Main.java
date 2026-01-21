package fr.formation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://www.google.fr"))
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            byte[] result = response.body();

            System.out.println(result.length);
        }

        catch (URISyntaxException ex) {
            System.out.println("Problème d'URI !");
        }

        catch (InterruptedException | IOException ex) {
            System.out.println("Problème de requête HTTP !");
        }
    }
}