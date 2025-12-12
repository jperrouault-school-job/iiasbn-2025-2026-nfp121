package fr.formation;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonApplication {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try (FileInputStream fis = new FileInputStream("/workspace/voitures.json")) {
            // Voiture[] voitures = mapper.readValue(fis, Voiture[].class);
            // List<Voiture> voituresList = Arrays.asList(voitures);
            List<Voiture> voitures = mapper.readValue(fis, new TypeReference<List<Voiture>>() { });

            // System.out.println(voitures.length);
            // System.out.println(voituresList.size());
            System.out.println(voitures.size());
            for (Voiture v : voitures) {
                System.out.println(v.getModele());
            }
        }

        catch (Exception ex) {
            System.out.println("OUPS ERREUR !!!");
        }
    }
}
