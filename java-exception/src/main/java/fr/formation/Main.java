package fr.formation;

public class Main {
    public static void main(String[] args) {
        VehiculeService service = new VehiculeService();

        try {
            service.checkVehicule();
        }

        catch (Exception e) {
            // e.printStackTrace();
            System.out.println("OK GERE !");
        }
    }
}