package fr.formation;

import fr.formation.repo.AlbumRepository;
import fr.formation.repo.PhotoRepository;
import fr.formation.service.AlbumService;
import fr.formation.service.PhotoService;

public class Main {
    public static void main(String[] args) {
        PhotoService photoService = BeanFactory.createBean(PhotoService.class);
        // AlbumService albumService = BeanFactory.createBean(AlbumService.class);
        // PhotoRepository photoRepository = BeanFactory.createBean(PhotoRepository.class);
        // AlbumRepository albumRepository = BeanFactory.createBean(AlbumRepository.class);

        System.out.println(photoService);
        // System.out.println(photoRepository);
        // System.out.println(albumRepository);
        // System.out.println(albumService);

        photoService.findAll();
    }
}