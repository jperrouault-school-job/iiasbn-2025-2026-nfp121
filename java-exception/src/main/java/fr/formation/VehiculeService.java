package fr.formation;

public class VehiculeService {
    public void checkVehicule() throws Exception {
        throw new Exception("test");
    }


    public void create(String modele) throws VehiculeModeleNotEmptyException {
        if (modele == null || modele.isBlank()) {
            throw new VehiculeModeleNotEmptyException();
        }

        System.out.println("C OK C CREE");
    }
}
