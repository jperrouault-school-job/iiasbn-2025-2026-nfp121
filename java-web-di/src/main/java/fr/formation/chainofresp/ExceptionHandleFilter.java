package fr.formation.chainofresp;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.annotation.Component;
import fr.formation.http.HttpExceptionResponse;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import fr.formation.http.HttpResponseStatus;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ExceptionHandleFilter extends HttpFilter {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Gestion des exceptions ...");

        if (response.getHttpException() != null) {
            log.debug("Traitement de l'exception !");

            response.setStatus(HttpResponseStatus.BAD_REQUEST);

            try {
                response.write(mapper.writeValueAsString(HttpExceptionResponse.builder()
                    .message(response.getHttpException().getMessage())
                    .status(HttpResponseStatus.BAD_REQUEST.getCode())
                    .build()
                ));
            }

            catch (Exception e) {
                log.error("Impossible de sérialiser HttpExceptionResponse : {}", e.getMessage());
                response.write("");
            }
        }

        this.doNext(request, response);
    }
}
