package fr.formation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Voiture alpine = new Voiture("Alpine");
        Voiture fiatPunto = new Voiture("Punto");
        Voiture teslaX = new Voiture("Tesla X");

        List<Voiture> voitures = List.of(alpine, fiatPunto, teslaX);

        ObjectMapper mapper = new ObjectMapper();

        try (FileOutputStream fos = new FileOutputStream("/workspace/voitures.json")) {
            byte[] json = mapper.writeValueAsBytes(voitures);

            fos.write(json);
        }

        catch (JsonProcessingException ex) {
            System.out.println("OUPS");
        }

        catch (FileNotFoundException ex) {
            System.out.println("Fichier impossible à ouvrir");
        }

        catch (IOException ex) {
            System.out.println("Impossible d'écrire dans le fichie²r !");
        }
    }
}