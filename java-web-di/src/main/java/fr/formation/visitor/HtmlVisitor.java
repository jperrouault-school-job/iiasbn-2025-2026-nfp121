package fr.formation.visitor;

import fr.formation.http.HttpResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HtmlVisitor implements Visitor {
    @Override
    public void visit(HttpResponse response) {
        log.debug("Génération du contenu HTML ...");

        String result = response.getRawContent().toString();

        if (!result.isEmpty()) {
            response.write("""
            <!DOCTYPE>
            <html>
            <body>
                %s
            </body>
            </html>""".formatted(result));
        }
    }
}
