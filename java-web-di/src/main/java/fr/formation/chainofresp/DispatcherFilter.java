package fr.formation.chainofresp;

import fr.formation.WebApplicationContext;
import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.http.HttpContentType;
import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;
import fr.formation.http.HttpResponseStatus;
import fr.formation.http.WebMethod;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class DispatcherFilter extends HttpFilter {
    @Inject
    private WebApplicationContext ctx;

    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        WebMethod webMethod = this.ctx.getMethods().get(request.getPath());

        log.debug("Dispatch de la requete vers la route {} ...", request.getPath());

        response.setContentType(HttpContentType.TEXT_HTML);

        if (webMethod != null) {
            String result = webMethod.invoke(request, response).toString();

            if (!result.isEmpty()) {
                response.setStatus(HttpResponseStatus.OK);

                response.write("""
                <!DOCTYPE>
                <html>
                <body>
                    %s
                </body>
                </html>""".formatted(result));
            }
        }

        else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
        }

        this.doNext(request, response);
    }
}
