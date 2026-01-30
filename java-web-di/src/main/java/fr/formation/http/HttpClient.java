package fr.formation.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import fr.formation.WebApplicationContext;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HttpClient {
    public void handle(WebApplicationContext ctx, Socket client) {
        log.debug("Traitement de la requête HTTP ...");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String line = reader.readLine();
            String path = null;
            Map<String, String> queryParameters = new HashMap<>();

            if (line != null) {
                String requestTarget = line.split(" ")[1];
                URI uri = new URI(requestTarget);

                path = uri.getPath();

                if (uri.getQuery() != null) {
                    for (String queryParam : uri.getQuery().split("&")) {
                        String[] keyValue = queryParam.split("=");

                        queryParameters.put(keyValue[0], keyValue[1]);
                    }
                }

                log.debug("Le chemin demandé est : {}", path);
            }

            if (path == null) {
                log.error("Le chemin n'a pas été trouvé !");
            }

            WebMethod webMethod = ctx.getMethods().get(path);
            String result = "not found";

            if (webMethod != null) {
                result = webMethod.invoke(queryParameters).toString();
            }

            // Envoyer la réponse au client
            String responseBody = """
            <!DOCTYPE>
            <html>
            <body>
                {content}
            </body>
            </html>
            """.replace("{content}", result);

            byte[] responseBodyBytes = responseBody.getBytes(StandardCharsets.UTF_8);

            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Content-Type: text/html; charset=UTF-8\r\n");
            writer.write("Content-Length: " + responseBodyBytes.length + "\r\n");
            writer.write("Connection: close\r\n");
            writer.write("\r\n");
            writer.write(responseBody);

            writer.flush();

            log.debug("Fin de la connexion avec le client");

            client.close();
        }

        catch (Exception e) {
            log.error("Une erreur est survenue pendant la communication avec le client : {}", e.getMessage());
        }
    }
}
