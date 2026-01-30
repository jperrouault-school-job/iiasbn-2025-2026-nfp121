package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.http.HttpContentType;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import fr.formation.visitor.HtmlVisitor;
import fr.formation.visitor.JsonVisitor;
import fr.formation.visitor.Visitor;
import fr.formation.visitor.XmlVisitor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AcceptHeaderFilter extends HttpFilter {
    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        log.debug("Analyse du type de flux demandé dans la requete HTTP ...");

        HttpContentType contentType = this.retreiveContentType(request.getHeader("Accept"));

        log.debug("Flux demandé = {}", contentType);

        Visitor visitor = switch (contentType) {
            case APPLICATION_JSON   -> new JsonVisitor();
            case APPLICATION_XML    -> new XmlVisitor();
            default                 -> new HtmlVisitor();
        };

        // NOTE : Faire response.accept() au lieu de visitor.visit() permet d'aller sur la bonne surcharge du visiteur dans le cas où il y en aurait plusieurs !
        response.accept(visitor);

        this.doNext(request, response);
    }

    private HttpContentType retreiveContentType(String accept) {
        if ("application/json".equals(accept)) {
            return HttpContentType.APPLICATION_JSON;
        }

        if ("application/xml".equals(accept)) {
            return HttpContentType.APPLICATION_XML;
        }

        return HttpContentType.TEXT_HTML;
    }
}
