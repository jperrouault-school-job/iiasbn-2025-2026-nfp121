package fr.formation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferCopyApplication {
    public static void main(String[] args) {
        try (
            FileInputStream fis = new FileInputStream("/workspace/Java_Persistence_et_Hibernate.pdf");
            FileOutputStream fos = new FileOutputStream("/workspace/Java_Persistence_et_Hibernate.copy.pdf")
        ) {
            int len = 0;
            byte[] buffer = new byte[1024];

            System.out.println("Copie du fichier en cours ...");

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("Copie terminée !");
        }

        catch (FileNotFoundException ex) {
            System.out.println("Fichier introuvable !");
        }

        catch (IOException ex) {
            System.out.println("Erreur à la fermeture du fichier ...");
        }
    }
}
