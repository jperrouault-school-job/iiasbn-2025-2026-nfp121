package fr.formation;

import fr.formation.service.AlbumService;
import fr.formation.service.PhotoService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ApplicationContext("fr.formation");

        PhotoService photoService = ctx.getBean(PhotoService.class);
        AlbumService albumService = ctx.getBean(AlbumService.class);

        System.out.println(photoService);
        System.out.println(albumService);

        photoService.findAll();
        albumService.findAll();
    }
}