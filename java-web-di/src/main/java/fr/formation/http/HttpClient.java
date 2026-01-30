package fr.formation.http;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import fr.formation.chainofresp.HttpFilter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HttpClient {
    public void handle(HttpFilter filerChain, Socket client) {
        log.debug("Parsing de la requête HTTP ...");

        try {
            HttpRequest request = new HttpRequest();
            HttpResponse response = new HttpResponse();
            InputStream is = client.getInputStream();
            ByteArrayOutputStream linesBuffer = new ByteArrayOutputStream();

            int value;

            while ((value = is.read()) != -1) {
                linesBuffer.write(value);

                if (linesBuffer.toString().endsWith("\r\n\r\n")) {
                    break;
                }
            }

            String lines = linesBuffer.toString(StandardCharsets.US_ASCII);

            for (String line : lines.split("\r\n")) {
                request.getLines().add(line);

                if (!line.startsWith("Content-Length:")) {
                    continue;
                }

                int contentLength = Integer.parseInt(line.substring(15).trim());

                byte[] body = new byte[contentLength];
                int totalRead = 0;

                while (totalRead < contentLength) {
                    int read = is.read(body, totalRead, contentLength - totalRead);

                    if (read == -1) {
                        throw new IOException();
                    }

                    totalRead += read;
                }

                request.setBody(body);
            }

            filerChain.handle(request, response);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            byte[] responseBodyBytes = response.getContent() != null ? response.getContent().getBytes(StandardCharsets.UTF_8) : new byte[0];

            log.debug("Préparation et envoie de la réponse HTTP ...");
            StringBuilder responseBuilder = new StringBuilder("HTTP/1.1 ");

            responseBuilder.append(response.getStatus().getCode());
            responseBuilder.append(" ");
            responseBuilder.append(response.getStatus().name());
            responseBuilder.append("\r\n");

            responseBuilder.append("Content-Type: " + response.getContentType().getValue() + "; charset=UTF-8\r\n");
            responseBuilder.append("Content-Length: " + responseBodyBytes.length + "\r\n");
            responseBuilder.append("Connection: close\r\n");
            responseBuilder.append("\r\n");
            responseBuilder.append(response.getContent() != null ? response.getContent() : "");

            writer.write(responseBuilder.toString());
            writer.flush();

            log.debug("Fin de la connexion avec le client");

            client.close();
        }

        catch (Exception e) {
            log.error("Une erreur est survenue pendant la communication avec le client : {}", e.getMessage());
        }
    }
}
