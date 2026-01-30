package fr.formation.service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.HttpClientProxy;
import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.model.Photo;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PhotoService {
    @Inject
    private HttpClientProxy httpClient;

    public Photo findById(int id) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://jsonplaceholder.typicode.com/photos/" + id))
                .build()
            ;

            byte[] json = this.httpClient.send(request, BodyHandlers.ofByteArray()).body();

            return mapper.readValue(json, Photo.class);
        }

        catch (Exception e) {
            log.error("Impossible de récupérer la photo {} : {}", id, e.getMessage());

            return null;
        }
    }
}
