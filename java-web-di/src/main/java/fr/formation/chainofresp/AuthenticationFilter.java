package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AuthenticationFilter extends HttpFilter {
    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Authentification de la requete ...");

        String token = request.getHeader("Authorization");

        if (token != null) {
            log.debug("Authentification avec le token {} !", token);
        }

        this.doNext(request, response);
    }
}
