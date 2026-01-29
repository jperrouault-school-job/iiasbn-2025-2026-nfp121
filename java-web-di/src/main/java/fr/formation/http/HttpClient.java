package fr.formation.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import fr.formation.WebApplicationContext;

public class HttpClient {
    public void handle(WebApplicationContext ctx, Socket client) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String line = reader.readLine();
            String path = null;

            if (line != null) {
                String requestTarget = line.split(" ")[1];
                URI uri = new URI(requestTarget);

                path = uri.getPath();

                System.out.println("Le chemin demandé est : " + path);
            }

            if (path == null) {
                System.out.println("PATH NULL");
            }

            WebMethod webMethod = ctx.getMethods().get(path);
            String result = "not found";

            if (webMethod != null) {
                result = webMethod.invoke().toString();
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

            client.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
