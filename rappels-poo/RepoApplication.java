public class RepoApplication {
    public static void main(String[] args) {
        Repository<Vehicule, Integer> repo = null;

        repo.findById(1).rouler();
    }
}
