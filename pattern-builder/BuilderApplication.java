public class BuilderApplication {
    public static void main(String[] args) {
        DbConfig config = DbConfig.newBuilder()
            .username("root")
            .mysql("localhost")
            // .port(3306)
            // .type("mysql")
            .build()
        ;
    }
}
