package fr.formation;

public class Main {
    public static void main(String[] args) {
        VehiculeService service = new VehiculeService();

        // try {
        //     service.checkVehicule();
        // }

        // catch (Exception e) {
        //     // e.printStackTrace();
        //     System.out.println("OK GERE !");
        // }


        try {
            service.create(null);
        }

        catch (VehiculeModeleNotEmptyException ex) {
            System.out.println("Le modèle doit être pas vide !");
        }

        // catch (Exception ex) {
        //     System.out.println("Erreur inconnue : " + ex.getMessage());
        // }
    }
}