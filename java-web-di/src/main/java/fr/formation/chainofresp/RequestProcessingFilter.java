package fr.formation.chainofresp;

import java.net.URI;

import fr.formation.annotation.Component;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class RequestProcessingFilter extends HttpFilter {
    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Traitement de la requete");

        if (request.getLines().isEmpty()) {
            log.error("Aucune ligne dans la requête HTTP !");
            return;
        }

        this.retreivePathAndQueryParameters(request);
        this.retreiveHeaders(request);

        this.doNext(request, response);
    }

    private void retreivePathAndQueryParameters(HttpRequest request) {
        try {
            String requestTarget = request.getLines().remove(0).split(" ")[1];
            URI uri = new URI(requestTarget);

            request.setPath(uri.getPath());

            log.debug("Le chemin demandé est : {}", request.getPath());

            if (request.getPath() == null) {
                log.error("Le chemin n'a pas été trouvé !");
            }

            log.debug("Enregistrement des paramètres de requête si applicable...");

            if (uri.getQuery() != null) {
                for (String queryParam : uri.getQuery().split("&")) {
                    String[] keyValue = queryParam.split("=");

                    log.trace("Paramètre {} = {}", keyValue[0], keyValue[1]);

                    request.getParameters().put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        }

        catch (Exception e) {
            log.error("Une erreur est survenue pendant le traitement de la requête HTTP : {}", e.getMessage());
        }
    }

    private void retreiveHeaders(HttpRequest request) {
        try {
            for (String line : request.getLines()) {
                String[] keyValue = line.split(":");

                request.getHeaders().put(keyValue[0].trim(), keyValue[1].trim());
            }
        }

        catch (Exception e) {
            log.error("Une erreur est survenue pendant le traitement de la requête HTTP : {}", e.getMessage());
        }
    }
}
