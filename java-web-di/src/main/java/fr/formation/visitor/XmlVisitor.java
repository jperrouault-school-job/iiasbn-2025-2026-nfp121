package fr.formation.visitor;

import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.xml.XmlMapper;

@Log4j2
public class XmlVisitor implements Visitor {
    @Override
    public void visit(HttpResponse response) {
        ObjectMapper mapper = new XmlMapper();

        log.debug("Génération du contenu XML ...");

        try {
            response.write(mapper.writeValueAsString(response.getRawContent()));
        }

        catch (Exception e) {
            log.error("Impossible de sérialiser en JSON : {}", e.getMessage());
        }
    }
}
