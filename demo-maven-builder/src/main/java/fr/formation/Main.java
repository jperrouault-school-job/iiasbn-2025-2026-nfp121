package fr.formation;

public class Main {
    public static void main(String[] args) {
        // DbConfig config = DbConfig.builder()
        //     .host("localhost")
        //     .port(3306)
        //     .username("root")
        //     .build()
        // ;

        DbConfig config = DbConfig.builder()
            .mysql("localhost")
            .username("root")
            .build()
        ;

        System.out.println(config);
    }
}