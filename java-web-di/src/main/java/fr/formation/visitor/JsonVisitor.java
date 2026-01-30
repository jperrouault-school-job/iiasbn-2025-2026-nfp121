package fr.formation.visitor;

import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;
import tools.jackson.databind.ObjectMapper;

@Log4j2
public class JsonVisitor implements Visitor {
    @Override
    public void visit(HttpResponse response) {
        ObjectMapper mapper = new ObjectMapper();

        log.debug("Génération du contenu JSON ...");

        try {
            response.write(mapper.writeValueAsString(response.getRawContent()));
        }

        catch (Exception e) {
            log.error("Impossible de sérialiser en JSON : {}", e.getMessage());
        }
    }
}
