package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.http.HttpExceptionResponse;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import fr.formation.http.HttpResponseStatus;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ExceptionHandleFilter extends HttpFilter {
    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Gestion des exceptions ...");

        if (response.getHttpException() != null) {
            log.debug("Traitement de l'exception !");

            response.setStatus(HttpResponseStatus.BAD_REQUEST);

            try {
                response.setRawContent(HttpExceptionResponse.builder()
                    .message(response.getHttpException().getMessage())
                    .status(HttpResponseStatus.BAD_REQUEST.getCode())
                    .build()
                );
            }

            catch (Exception e) {
                log.error("Impossible de sérialiser HttpExceptionResponse : {}", e.getMessage());
            }
        }

        this.doNext(request, response);
    }
}
