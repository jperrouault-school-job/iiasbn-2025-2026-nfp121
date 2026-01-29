package fr.formation.service;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.repo.AlbumRepository;
import fr.formation.repo.PhotoRepository;

@Component
public class AlbumService {
    @Inject
    private AlbumRepository repository;

    @Inject
    private PhotoRepository photoRepository;

    public int findAll() {
        System.out.println(this.repository + " - " + this.photoRepository);
        return this.repository.findAll().size();
    }
}
