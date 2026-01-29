import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    public void handle(Socket client) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            // Lire ce que nous envoie le client
            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                System.out.println(line);
            }

            // Envoyer la réponse au client
            String responseBody = """
            <!DOCTYPE>
            <html>
            <body>
                <h1>Hello from Java!</h1>
            </body>
            </html>
            """;

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
