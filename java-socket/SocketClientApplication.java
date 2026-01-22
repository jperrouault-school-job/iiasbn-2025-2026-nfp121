import java.net.Socket;

public class SocketClientApplication {
    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 1234)) {
            System.out.println("Connexion OK!");

            client.getOutputStream().write(67);
        }

        catch (Exception e) {
            System.out.println("Impossible de se connecter ?!");
        }
    }
}
