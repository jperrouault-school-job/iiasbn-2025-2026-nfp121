import java.util.ArrayList;
import java.util.List;

public class VehiculeApplication {
    public static void main(String[] args) {
        Vehicule voiture = new Voiture();
        Vehicule moto = new Moto();
        List<Vehicule> vehicules = new ArrayList<>();

        vehicules.add(voiture);
        vehicules.add(moto);
        // vehicules.add("moto");
        addStringToList(vehicules);

        for (Vehicule v : vehicules) {
            if (v instanceof Vehicule vehicule) {
                vehicule.rouler();
            }
        }
    }

    public static void addStringToList(List list) {
        list.add("la moto");
    }
}
