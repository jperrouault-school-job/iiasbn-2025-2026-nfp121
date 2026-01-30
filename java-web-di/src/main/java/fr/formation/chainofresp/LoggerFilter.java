package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class LoggerFilter extends HttpFilter {
    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Log de la requete");

        this.doNext(request, response);
    }
}
