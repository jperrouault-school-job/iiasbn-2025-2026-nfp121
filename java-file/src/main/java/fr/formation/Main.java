package fr.formation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Stream pour les octets
        // Output pour l'écriture
        // Input pour la lecture
        // File pour manipuler un fichier

        // Un fichier, en écriture d'octets : FileOutputStream

        // FileOutputStream fos = null;

        // try {
        //     fos = new FileOutputStream("lefichier.txt");
        // }

        // catch (FileNotFoundException ex) {
        //     System.out.println("Fichier introuvable !");
        // }

        // finally {
        //     if (fos != null) {
        //         try {
        //             fos.close();
        //         }

        //         catch (IOException ex) {
        //             System.out.println("Erreur à la fermeture du fichier ...");
        //         }
        //     }
        // }

        try (FileOutputStream fos = new FileOutputStream("lefichier.txt")) {
            // fos.write("Démonstration".getBytes());
            fos.write(65);
        }

        catch (FileNotFoundException ex) {
            System.out.println("Fichier introuvable !");
        }

        catch (IOException ex) {
            System.out.println("Erreur à la fermeture du fichier ...");
        }

        try (FileInputStream fis = new FileInputStream("lefichier.txt")) {
            int val = 0;

            while ((val = fis.read()) != -1) {
                System.out.println((byte)val);
            }
        }

        catch (FileNotFoundException ex) {
            System.out.println("Fichier introuvable !");
        }

        catch (IOException ex) {
            System.out.println("Erreur à la fermeture du fichier ...");
        }
    }
}