package fr.formation;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://jsonplaceholder.typicode.com/photos"))
                .build()
            ;

            byte[] json = httpClient.send(request, BodyHandlers.ofByteArray()).body();

            List<Photo> photos = mapper.readValue(json, new TypeReference<List<Photo>>() { });

            photos.stream()
                .filter(p -> p.getTitle().length() > 40)
                .map(Photo::getTitle)
                .forEach(System.out::println)
            ;

            double moyenne = photos.stream()
                .map(Photo::getTitle)
                .mapToInt(String::length)
                .average()
                .orElse(0)
            ;

            System.out.println("Moyenne des caractères = " + moyenne);
        }

        catch (Exception ex) {
            System.out.println("Une erreur est survenue : " + ex.getMessage());
        }
    }
}